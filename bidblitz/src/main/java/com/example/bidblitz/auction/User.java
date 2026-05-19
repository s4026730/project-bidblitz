package com.example.bidblitz.auction;

public class User {
    private String id;
    private String fullName;
    private double balance;
    private double rating;

    // Constructor
    public User(
            String id,
            String fullName,
            double balance,
            double rating
    ) {
        this.id = id;
        this.fullName = fullName;
        this.balance = balance;
        this.rating = rating;
    }

    // Functions
    public void topUp(double amount) {
        if (amount <= 0 || amount > 10000) {
            throw new IllegalArgumentException(
                    "Invalid top-up amount"
            );
        }
        balance += amount;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public double getBalance() {
        return balance;
    }

    public double getRating() {
        return rating;
    }

    // Display
    @Override
    public String toString() {
        return id
                + " - "
                + fullName
                + " - Balance: "
                + balance;
    }
}