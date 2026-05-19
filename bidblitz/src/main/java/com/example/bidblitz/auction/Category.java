package com.example.bidblitz.auction;

public class Category {
    private String categoryId;
    private String name;
    private String description;
    private double commissionRate;

    // Full Constructor
    public Category(
            String categoryId,
            String name,
            String description,
            double commissionRate
    ) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.commissionRate = commissionRate;
    }

    // Simplified Constructor
    public Category(
            String categoryId,
            String name,
            double commissionRate
    ) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = "";
        this.commissionRate = commissionRate;
    }

    // Getters
    public String getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    // Display
    @Override
    public String toString() {
        return categoryId
                + " - "
                + name
                + " (Fee: "
                + (commissionRate * 100)
                + "%)";
    }
}
