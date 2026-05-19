package com.example.bidblitz.auction;

import java.time.LocalDateTime;
import java.util.UUID;

public final class Bid {
    private final String bidId;
    private final Item item;
    private final User bidder;
    private final double amount;
    private final LocalDateTime bidTime;

    // Constructor
    public Bid(
            Item item,
            User bidder,
            double amount
    ) {
        this.bidId = UUID.randomUUID().toString();
        this.item = item;
        this.bidder = bidder;
        this.amount = amount;
        this.bidTime = LocalDateTime.now();
    }

    // Getters
    public String getBidId() {
        return bidId;
    }

    public Item getItem() {
        return item;
    }

    public User getBidder() {
        return bidder;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getBidTime() {
        return bidTime;
    }

    // Display
    @Override
    public String toString() {
        return bidder.getFullName()
                + " bid $"
                + amount
                + " at "
                + bidTime;
    }
}