package com.example.bidblitz.model;

/**
 * @author Team 6
 */

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "bids")
public class Bid implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "bidder_id", nullable = false)
    private User bidder;

    @Column(name = "amount", nullable = false)
    private final double amount;

    @Column(name = "bid_date_time", nullable = false)
    private final LocalDateTime bidDateTime;

    public Bid() {
        this.amount = 0.0;
        this.bidDateTime = LocalDateTime.now();
    }

    public Bid(Item item, User bidder, double amount) {
        this.item = item;
        this.bidder = bidder;
        this.amount = amount;
        this.bidDateTime = LocalDateTime.now();
    }

    public int getId() { return id; }
    public Item getItem() { return item; }
    public User getBidder() { return bidder; }
    public double getAmount() { return amount; }
    public LocalDateTime getBidDateTime() { return bidDateTime; }

    public void displayInfo() {
        System.out.println("Bid ID    : " + id);
        System.out.println("Item      : " + (item != null ? item.getTitle() : "N/A"));
        System.out.println("Bidder    : " + (bidder != null ? bidder.getUsername() : "N/A"));
        System.out.println("Amount    : $" + String.format("%.2f", amount));
        System.out.println("Date/Time : " + bidDateTime);
    }

    @Override
    public String toString() {
        return "Bid{"
                + "id=" + id
                + ", bidder='" + (bidder != null ? bidder.getUsername() : "N/A") + "'"
                + ", amount=" + String.format("%.2f", amount)
                + ", dateTime=" + bidDateTime
                + "}";
    }
}
