package com.example.bidblitz.service;

import com.example.bidblitz.model.Item;
import java.time.LocalDateTime;

public class ItemService {
    public void validateItem(Item item){
        // Item object cannot be null
        if(item == null){
            throw new IllegalArgumentException(
                    "Item cannot be null"
            );
        }

        // Title cannot be empty
        if(item.getTitle() == null ||
                item.getTitle().isBlank()){
            throw new IllegalArgumentException(
                    "Item title is required"
            );
        }

        // Starting price must be > 0
        if(item.getStartingPrice() <= 0){
            throw new IllegalArgumentException(
                    "Invalid starting price"
            );
        }

        // Reserve price cannot be negative
        if(item.getReservePrice() < 0){
            throw new IllegalArgumentException(
                    "Invalid reserve price"
            );
        }

        // Seller must exist
        if(item.getSeller() == null){
            throw new IllegalArgumentException(
                    "Seller is required"
            );
        }

        // Category must exist
        if(item.getCategory() == null){
            throw new IllegalArgumentException(
                    "Category is required"
            );
        }

        // Listing start date must exist
        if(item.getListingStart() == null){
            throw new IllegalArgumentException(
                    "Listing start date is required"
            );
        }

        // Listing end date must exist
        if(item.getListingEnd() == null){
            throw new IllegalArgumentException(
                    "Listing end date is required"
            );
        }

        // End date must be after start date
        if(item.getListingEnd()
                .isBefore(item.getListingStart())){
            throw new IllegalArgumentException(
                    "End date must be after start date"
            );
        }
    }

    public boolean isItemActive(Item item){
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(item.getListingStart())
                && now.isBefore(item.getListingEnd());
    }

    public void addItem(Item item){
        // Validate item first
        validateItem(item);
        // Temporary console output
        System.out.println(
                "Item added successfully: "
                        + item.getTitle()
        );
    }
}