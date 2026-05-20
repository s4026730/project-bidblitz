package com.example.bidblitz.model;

/**
 * @author Team 6
 */

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categories")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "commission_rate")
    private double commissionRate;

    public Category() {
    }

    public Category(String name, String description, double commissionRate) {
        this.name = name;
        this.description = description;
        this.commissionRate = commissionRate;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getCommissionRate() { return commissionRate; }
    public void setCommissionRate(double commissionRate) { this.commissionRate = commissionRate; }

    public void displayInfo() {
        System.out.println("Category ID  : " + id);
        System.out.println("Name         : " + name);
        System.out.println("Description  : " + description);
        System.out.println("Commission   : " + commissionRate + "%");
    }

    @Override
    public String toString() {
        return "Category{"
                + "id=" + id
                + ", name='" + name + "'"
                + ", commissionRate=" + commissionRate + "%"
                + "}";
    }
}
