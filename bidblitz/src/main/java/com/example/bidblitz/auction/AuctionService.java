package com.example.bidblitz.auction;

import java.util.ArrayList;
import java.util.List;

public class AuctionService {
    private List<Auction> auctions;

    public AuctionService() {
        auctions = new ArrayList<>();
    }

    public void addAuction(Auction auction) {
        auctions.add(auction);
    }

    public List<Auction> getAuctions() {
        return auctions;
    }

    public Auction findAuctionById(String auctionId) {
        for (Auction auction : auctions) {
            if (auction.getAuctionId().equals(auctionId)) {
                return auction;
            }
        }
        return null;
    }
}