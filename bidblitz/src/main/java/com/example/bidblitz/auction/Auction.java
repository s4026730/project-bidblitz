package com.example.bidblitz.auction;

/**
 * Auction Logic Class
 * Reused and simplified from Assignment 1
 *
 * @author Bùi Quốc Huy
 */

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Auction {

    private String auctionId;
    private Item item;

    private AuctionStatus status;

    private List<Bid> bids;

    private Bid highestBid;
    private User winner;

    private double finalPrice;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    private static final double MIN_INCREMENT = 1.0;

    // Constructor
    public Auction(Item item) {
        this.auctionId = UUID.randomUUID().toString();

        this.item = item;

        this.status = AuctionStatus.ACTIVE;

        this.bids = new ArrayList<>();

        this.startDateTime = item.getStartDateTime();
        this.endDateTime = item.getEndDateTime();
    }

    // =========================
    // Auction Functions
    // =========================

    public void placeBid(Bid bid) {

        // Seller cannot bid own item
        if (bid.getBidder().equals(item.getSeller())) {
            throw new IllegalArgumentException("Seller cannot bid own item");
        }

        double currentPrice;

        if (highestBid == null) {
            currentPrice = item.getStartingPrice();
        } else {
            currentPrice = highestBid.getAmount();
        }

        // Validate minimum increment
        if (bid.getAmount() < currentPrice + MIN_INCREMENT) {
            throw new IllegalArgumentException(
                    "Bid must be at least $" + MIN_INCREMENT + " higher"
            );
        }

        bids.add(bid);

        highestBid = bid;
    }

    public void closeAuction() {

        status = AuctionStatus.ENDED;

        // No bids
        if (highestBid == null) {
            status = AuctionStatus.UNSOLD;
            return;
        }

        double highestAmount = highestBid.getAmount();

        // Reserve price check
        if (item.getReservePrice() != null &&
                highestAmount < item.getReservePrice()) {

            status = AuctionStatus.UNSOLD;
            return;
        }

        finalPrice = highestAmount;

        winner = highestBid.getBidder();

        status = AuctionStatus.SOLD;
    }

    // =========================
    // Getters
    // =========================

    public String getAuctionId() {
        return auctionId;
    }

    public Item getItem() {
        return item;
    }

    public AuctionStatus getStatus() {
        return status;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public Bid getHighestBid() {
        return highestBid;
    }

    public User getWinner() {
        return winner;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    // =========================
    // Display
    // =========================

    @Override
    public String toString() {

        double currentPrice;

        if (highestBid == null) {
            currentPrice = item.getStartingPrice();
        } else {
            currentPrice = highestBid.getAmount();
        }

        String highestBidder;

        if (highestBid == null) {
            highestBidder = "No bids";
        } else {
            highestBidder = highestBid.getBidder().getId();
        }

        return item.getDisplayID()
                + " | "
                + item.getTitle()
                + " | Current: $"
                + currentPrice
                + " | Highest Bidder: "
                + highestBidder
                + " | Status: "
                + status
                + " | Ends: "
                + endDateTime;
    }
}