package com.example.bidblitz.model;

/**
 * @author Team 6
 */

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "items")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "starting_price")
    private double startingPrice;

    @Column(name = "reserve_price")
    private double reservePrice;

    @Column(name = "condition")
    private String condition;

    @Column(name = "listing_start")
    private LocalDateTime listingStart;

    @Column(name = "listing_end")
    private LocalDateTime listingEnd;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    @Column(name = "image_url")
    private String imageUrl;

    public Item() {
    }

    public Item(String title, String description, Category category,
                double startingPrice, double reservePrice, String condition,
                LocalDateTime listingStart, LocalDateTime listingEnd, User seller) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.startingPrice = startingPrice;
        this.reservePrice = reservePrice;
        this.condition = condition;
        this.listingStart = listingStart;
        this.listingEnd = listingEnd;
        this.seller = seller;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public double getStartingPrice() { return startingPrice; }
    public void setStartingPrice(double startingPrice) { this.startingPrice = startingPrice; }
    public double getReservePrice() { return reservePrice; }
    public void setReservePrice(double reservePrice) { this.reservePrice = reservePrice; }
    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }
    public LocalDateTime getListingStart() { return listingStart; }
    public void setListingStart(LocalDateTime listingStart) { this.listingStart = listingStart; }
    public LocalDateTime getListingEnd() { return listingEnd; }
    public void setListingEnd(LocalDateTime listingEnd) { this.listingEnd = listingEnd; }
    public User getSeller() { return seller; }
    public void setSeller(User seller) { this.seller = seller; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public void displayInfo() {
        System.out.println("Item ID      : " + id);
        System.out.println("Title        : " + title);
        System.out.println("Category     : " + (category != null ? category.getName() : "N/A"));
        System.out.println("Start Price  : $" + String.format("%.2f", startingPrice));
        System.out.println("Reserve Price: $" + String.format("%.2f", reservePrice));
        System.out.println("Condition    : " + condition);
        System.out.println("Seller       : " + (seller != null ? seller.getUsername() : "N/A"));
    }

    public boolean isActive() {
        // Current system time
        LocalDateTime now = LocalDateTime.now();

        // Return true if current time
        // is between listing start and end
        return now.isAfter(listingStart)
                && now.isBefore(listingEnd);
    }

    @Override
    public String toString() {
        return "Item{"
                + "id=" + id
                + ", title='" + title + "'"
                + ", startingPrice=" + String.format("%.2f", startingPrice)
                + ", condition='" + condition + "'"
                + "}";
    }
}
