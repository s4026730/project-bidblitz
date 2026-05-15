package com.example.bidblitz.auction;

import java.time.LocalDateTime;

public class Item {

    private String displayID;
    private String title;

    private double startingPrice;
    private Double reservePrice;

    private User seller;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public Item(
            String displayID,
            String title,
            double startingPrice,
            Double reservePrice,
            User seller,
            LocalDateTime startDateTime,
            LocalDateTime endDateTime
    ) {
        this.displayID = displayID;
        this.title = title;
        this.startingPrice = startingPrice;
        this.reservePrice = reservePrice;
        this.seller = seller;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public String getDisplayID() {
        return displayID;
    }

    public String getTitle() {
        return title;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public Double getReservePrice() {
        return reservePrice;
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
}
