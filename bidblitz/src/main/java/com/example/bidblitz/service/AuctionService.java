package com.example.bidblitz.service;

/**
 * @author Team 6
 */

import com.example.bidblitz.model.*;
import com.example.bidblitz.repository.*;
import java.time.LocalDateTime;
import java.util.List;

public class AuctionService {

    private static final double MIN_BID_INCREMENT = 1.0;

    private AuctionRepository auctionRepository;
    private BidRepository bidRepository;
    private PaymentRepository paymentRepository;
    private ActivityLogRepository logRepository;

    public AuctionService() {
        this.auctionRepository = new AuctionRepository();
        this.bidRepository = new BidRepository();
        this.paymentRepository = new PaymentRepository();
        this.logRepository = new ActivityLogRepository();
    }

    public boolean addAuction(Auction auction) {
        if (auction == null || auction.getItem() == null) {
            return false;
        }
        return auctionRepository.add(auction);
    }

    public boolean updateAuction(Auction auction) {
        if (auction == null) {
            return false;
        }
        return auctionRepository.update(auction);
    }

    public boolean deleteAuction(int auctionId) {
        return auctionRepository.delete(auctionId);
    }

    public Auction getAuctionById(int auctionId) {
        return auctionRepository.findById(auctionId);
    }

    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    public List<Auction> getActiveAuctions() {
        return auctionRepository.findActive();
    }

    public List<Auction> getAuctionsByStatus(String status) {
        return auctionRepository.findByStatus(status);
    }

    public List<Auction> getAuctionsByEndDateRange(LocalDateTime from, LocalDateTime to) {
        return auctionRepository.findByEndDateRange(from, to);
    }

    public List<Auction> getAuctionsByCategory(int categoryId) {
        return auctionRepository.findByCategoryId(categoryId);
    }

    public boolean placeBid(Auction auction, User bidder, double amount) {
        if (auction == null || bidder == null) {
            return false;
        }
        if (!auction.getStatus().equals(Auction.ACTIVE)) {
            return false;
        }
        if (auction.getEndDateTime().isBefore(LocalDateTime.now())) {
            return false;
        }
        // sellers cannot bid on their own items
        if (auction.getItem().getSeller().getId() == bidder.getId()) {
            return false;
        }
        // bid must exceed current highest by at least minimum increment
        double minRequired = auction.getCurrentHighestBid() > 0
                ? auction.getCurrentHighestBid() + MIN_BID_INCREMENT
                : auction.getItem().getStartingPrice();
        if (amount < minRequired) {
            return false;
        }
        if (bidder.getAccountBalance() < amount) {
            return false;
        }
        Bid bid = new Bid(auction.getItem(), bidder, amount);
        boolean bidSaved = bidRepository.add(bid);
        if (!bidSaved) {
            return false;
        }
        auction.addBid(bid);
        auction.setHighestBid(bid);
        auction.setCurrentHighestBid(amount);
        boolean auctionUpdated = auctionRepository.update(auction);
        if (auctionUpdated) {
            ActivityLog log = new ActivityLog(bidder, ActivityLog.ACTION_BID,
                    "Auction", auction.getId(),
                    bidder.getUsername() + " placed bid of $" + String.format("%.2f", amount));
            logRepository.add(log);
        }
        return auctionUpdated;
    }

    public boolean cancelAuction(Auction auction, User actor) {
        if (auction == null) {
            return false;
        }
        // only active auctions can be cancelled
        if (!auction.getStatus().equals(Auction.ACTIVE)) {
            return false;
        }
        auction.setStatus(Auction.CANCELLED);
        boolean updated = auctionRepository.update(auction);
        if (updated) {
            ActivityLog log = new ActivityLog(actor, ActivityLog.ACTION_UPDATE,
                    "Auction", auction.getId(), "Auction cancelled by " + actor.getUsername());
            logRepository.add(log);
        }
        return updated;
    }

    public int processDueAuctions() {
        List<Auction> dueAuctions = auctionRepository.findDueAuctions();
        int count = 0;
        for (Auction auction : dueAuctions) {
            processOneAuction(auction);
            count++;
        }
        return count;
    }

    private void processOneAuction(Auction auction) {
        // no bids placed
        if (auction.getCurrentHighestBid() == 0) {
            auction.setStatus(Auction.UNSOLD);
            auctionRepository.update(auction);
            return;
        }
        // reserve price not met
        double reserve = auction.getItem().getReservePrice();
        if (reserve > 0 && auction.getCurrentHighestBid() < reserve) {
            auction.setStatus(Auction.UNSOLD);
            auctionRepository.update(auction);
            return;
        }
        auction.setStatus(Auction.SOLD);
        auction.setFinalSalePrice(auction.getCurrentHighestBid());
        User winner = auction.getHighestBid().getBidder();
        auction.setWinner(winner);
        auctionRepository.update(auction);

        double commRate = auction.getItem().getCategory().getCommissionRate();
        Payment payment = new Payment(auction, winner, auction.getItem().getSeller(),
                auction.getCurrentHighestBid(), commRate);
        paymentRepository.add(payment);

        winner.setRating(Math.min(5.0, winner.getRating() + 0.1));
        auction.getItem().getSeller().setRating(Math.min(5.0, auction.getItem().getSeller().getRating() + 0.1));
    }
}
