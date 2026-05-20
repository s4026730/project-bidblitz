package com.example.bidblitz;

import com.example.bidblitz.model.Item;
import com.example.bidblitz.service.ItemService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemServiceTest {

    // Create service object
    ItemService itemService = new ItemService();

    @Test
    void shouldRejectBlankTitle(){
        // Create test item
        Item item = new Item();
        item.setTitle("");
        item.setStartingPrice(100);
        // Expect exception
        assertThrows(
                IllegalArgumentException.class,
                () -> itemService.validateItem(item)
        );
    }

    @Test
    void shouldRejectNegativePrice(){
        // Create test item
        Item item = new Item();
        item.setTitle("Gaming Mouse");
        item.setStartingPrice(-50);
        // Expect exception
        assertThrows(
                IllegalArgumentException.class,
                () -> itemService.validateItem(item)
        );
    }
}
