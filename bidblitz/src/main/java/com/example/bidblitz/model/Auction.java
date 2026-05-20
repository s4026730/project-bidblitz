package com.example.bidblitz.model;

/**
 * @author Team 6
 */

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "auctions")
public class Auction implements Serializable {

    public static final String ACTIVE    = "ACTIVE";
    public static final String ENDED     = "ENDED";
    public static final String SOLD      = "SOLD";
    public static final String UNSOLD    = "UNSOLD";
    public static final String CANCELLED = "CANCELLED";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "auction_id")
    private List<Bid> bids;

    @ManyToOne
    @JoinColumn(name = "highest_bid_id")
    private Bid highestBid;

    @Column(name = "current_highest_bid")
    private double currentHighestBid;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private User winner;

    @Column(name = "final_sale_price")
    private double finalSalePrice;

    @Column(name = "start_date_time")
    private LocalDateTime startDateTime;

    @Column(name = "end_date_time")
    private LocalDateTime endDateTime;

    public Auction() {
        this.status = ACTIVE;
        this.bids = new ArrayList<Bid>();
        this.currentHighestBid = 0.0;
        this.finalSalePrice = 0.0;
    }

    public Auction(Item item, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.item = item;
        this.status = ACTIVE;
        this.bids = new ArrayList<Bid>();
        this.currentHighestBid = 0.0;
        this.finalSalePrice = 0.0;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public int getId() { return id; }
    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<Bid> getBids() { return bids; }
    public void addBid(Bid bid) { bids.add(bid); }
    public Bid getHighestBid() { return highestBid; }
    public void setHighestBid(Bid highestBid) { this.highestBid = highestBid; }
    public double getCurrentHighestBid() { return currentHighestBid; }
    public void setCurrentHighestBid(double currentHighestBid) { this.currentHighestBid = currentHighestBid; }
    public User getWinner() { return winner; }
    public void setWinner(User winner) { this.winner = winner; }
    public double getFinalSalePrice() { return finalSalePrice; }
    public void setFinalSalePrice(double finalSalePrice) { this.finalSalePrice = finalSalePrice; }
    public LocalDateTime getStartDateTime() { return startDateTime; }
    public void setStartDateTime(LocalDateTime startDateTime) { this.startDateTime = startDateTime; }
    public LocalDateTime getEndDateTime() { return endDateTime; }
    public void setEndDateTime(LocalDateTime endDateTime) { this.endDateTime = endDateTime; }

    public void displayInfo() {
        System.out.println("Auction ID   : " + id);
        System.out.println("Item         : " + (item != null ? item.getTitle() : "N/A"));
        System.out.println("Status       : " + status);
        System.out.println("Highest Bid  : $" + String.format("%.2f", currentHighestBid));
        System.out.println("Winner       : " + (winner != null ? winner.getUsername() : "N/A"));
        System.out.println("Final Price  : $" + String.format("%.2f", finalSalePrice));
        System.out.println("End          : " + endDateTime);
    }

    @Override
    public String toString() {
        return "Auction{"
                + "id=" + id
                + ", item='" + (item != null ? item.getTitle() : "N/A") + "'"
                + ", status='" + status + "'"
                + ", highestBid=" + String.format("%.2f", currentHighestBid)
                + "}";
    }
}
