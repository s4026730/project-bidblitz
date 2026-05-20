package com.example.bidblitz.model;

/**
 * @author Team 6
 */

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment implements Serializable {

    public static final String PENDING   = "PENDING";
    public static final String COMPLETED = "COMPLETED";
    public static final String FAILED    = "FAILED";
    public static final String REFUNDED  = "REFUNDED";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "auction_id", nullable = false)
    private Auction auction;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "commission_amount")
    private double commissionAmount;

    @Column(name = "seller_payout")
    private double sellerPayout;

    @Column(name = "status")
    private String status;

    @Column(name = "payment_date_time")
    private LocalDateTime paymentDateTime;

    public Payment() {
        this.status = PENDING;
        this.paymentDateTime = LocalDateTime.now();
    }

    public Payment(Auction auction, User buyer, User seller, double totalAmount, double commissionRate) {
        this.auction = auction;
        this.buyer = buyer;
        this.seller = seller;
        this.totalAmount = totalAmount;
        this.commissionAmount = totalAmount * (commissionRate / 100.0);
        this.sellerPayout = totalAmount - this.commissionAmount;
        this.status = PENDING;
        this.paymentDateTime = LocalDateTime.now();
    }

    public int getId() { return id; }
    public Auction getAuction() { return auction; }
    public User getBuyer() { return buyer; }
    public User getSeller() { return seller; }
    public double getTotalAmount() { return totalAmount; }
    public double getCommissionAmount() { return commissionAmount; }
    public double getSellerPayout() { return sellerPayout; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getPaymentDateTime() { return paymentDateTime; }

    public void displayInfo() {
        System.out.println("Payment ID   : " + id);
        System.out.println("Auction ID   : " + (auction != null ? auction.getId() : "N/A"));
        System.out.println("Buyer        : " + (buyer != null ? buyer.getUsername() : "N/A"));
        System.out.println("Seller       : " + (seller != null ? seller.getUsername() : "N/A"));
        System.out.println("Total        : $" + String.format("%.2f", totalAmount));
        System.out.println("Commission   : $" + String.format("%.2f", commissionAmount));
        System.out.println("Seller Payout: $" + String.format("%.2f", sellerPayout));
        System.out.println("Status       : " + status);
    }

    @Override
    public String toString() {
        return "Payment{"
                + "id=" + id
                + ", total=" + String.format("%.2f", totalAmount)
                + ", status='" + status + "'"
                + "}";
    }
}
