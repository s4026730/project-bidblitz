package com.example.bidblitz.model;

/**
 * @author Team 6
 */

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends Person {

    public static final String ROLE_USER = "REGISTERED_USER";
    public static final String ROLE_AUCTION_ADMIN = "AUCTION_ADMIN";
    public static final String ROLE_SYSTEM_ADMIN = "SYSTEM_ADMIN";

    @Column(name = "account_balance")
    private double accountBalance;

    @Column(name = "rating")
    private double rating;

    @ElementCollection
    @CollectionTable(name = "user_watchlist", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "item_id")
    private List<Integer> watchlistIds;

    public User() {
        super();
        this.accountBalance = 0.0;
        this.rating = 0.0;
        this.watchlistIds = new ArrayList<Integer>();
    }

    public User(String fullName, LocalDateTime dateOfBirth, String email,
                String phone, String username, String password,
                String role, double accountBalance) {
        super(fullName, dateOfBirth, email, phone, username, password, role);
        this.accountBalance = accountBalance;
        this.rating = 0.0;
        this.watchlistIds = new ArrayList<Integer>();
    }

    public double getAccountBalance() { return accountBalance; }
    public void setAccountBalance(double accountBalance) { this.accountBalance = accountBalance; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public List<Integer> getWatchlistIds() { return watchlistIds; }

    public void addToWatchlist(int itemId) {
        if (!watchlistIds.contains(itemId)) {
            watchlistIds.add(itemId);
        }
    }

    public void removeFromWatchlist(int itemId) {
        watchlistIds.remove(Integer.valueOf(itemId));
    }

    // top-up amount must be between $5 and $10,000
    public boolean topUp(double amount) {
        if (amount < 5.0 || amount > 10000.0) {
            return false;
        }
        this.accountBalance += amount;
        return true;
    }

    @Override
    public void displayInfo() {
        System.out.println("User ID  : " + getId());
        System.out.println("Name     : " + getFullName());
        System.out.println("Username : " + getUsername());
        System.out.println("Email    : " + getEmail());
        System.out.println("Balance  : $" + String.format("%.2f", accountBalance));
        System.out.println("Rating   : " + rating);
        System.out.println("Role     : " + getRole());
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + getId()
                + ", username='" + getUsername() + "'"
                + ", email='" + getEmail() + "'"
                + ", balance=" + String.format("%.2f", accountBalance)
                + ", role='" + getRole() + "'"
                + "}";
    }
}
