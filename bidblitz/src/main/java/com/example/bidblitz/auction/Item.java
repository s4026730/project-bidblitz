package com.example.bidblitz.auction;

/**
 * Item Model
 *
 * Reused and simplified from Assignment 1
 *
 * @author Bùi Quốc Huy
 */

import java.time.LocalDateTime;
import java.util.UUID;

public class Item {
    private String itemID;
    private String displayID;
    private String title;
    private String description;
    private Category category;
    private double startingPrice;
    private Double reservePrice;
    private String condition;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private User seller;

    // Constructor
    public Item(
            String displayID,
            String title,
            String description,
            Category category,
            double startingPrice,
            Double reservePrice,
            String condition,
            LocalDateTime startDateTime,
            LocalDateTime endDateTime,
            User seller
    ) {

        this.itemID = UUID.randomUUID().toString();
        this.displayID = displayID;
        this.title = title;
        this.description = description;
        this.category = category;
        this.startingPrice = startingPrice;
        this.reservePrice = reservePrice;
        this.condition = condition;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.seller = seller;
    }

    // Functions
    public boolean isActive() {

        LocalDateTime now = LocalDateTime.now();

        return now.isAfter(startDateTime)
                && now.isBefore(endDateTime);
    }

    // Getters
    public String getItemID() {
        return itemID;
    }

    public String getDisplayID() {
        return displayID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public Double getReservePrice() {
        return reservePrice;
    }

    public String getCondition() {
        return condition;
    }

    public User getSeller() {
        return seller;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    // Display
    @Override
    public String toString() {
        return displayID
                + " - "
                + title
                + " - $"
                + startingPrice;
    }
}