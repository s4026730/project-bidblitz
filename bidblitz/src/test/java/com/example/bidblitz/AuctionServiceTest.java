package com.example.bidblitz;

/**
 * @author Team 6
 */

import com.example.bidblitz.model.*;
import com.example.bidblitz.service.AuctionService;
import com.example.bidblitz.service.UserService;
import org.junit.jupiter.api.*;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuctionServiceTest {

    private static AuctionService auctionService;
    private static UserService userService;

    @BeforeAll
    static void setUp() {
        auctionService = new AuctionService();
        userService = new UserService();
    }

    @Test
    @Order(1)
    void testGetAllAuctions() {
        List<Auction> auctions = auctionService.getAllAuctions();
        assertNotNull(auctions, "Should return list of auctions");
    }

    @Test
    @Order(2)
    void testGetActiveAuctions() {
        List<Auction> active = auctionService.getActiveAuctions();
        assertNotNull(active, "Should return list of active auctions");
        for (Auction a : active) {
            assertEquals(Auction.ACTIVE, a.getStatus(), "All returned auctions should be ACTIVE");
        }
    }

    @Test
    @Order(3)
    void testGetAuctionsByStatus() {
        List<Auction> sold = auctionService.getAuctionsByStatus(Auction.SOLD);
        assertNotNull(sold, "Should return list");
        for (Auction a : sold) {
            assertEquals(Auction.SOLD, a.getStatus());
        }
    }

    @Test
    @Order(4)
    void testPlaceBidSelfBidding() {
        List<Auction> active = auctionService.getActiveAuctions();
        if (active.isEmpty()) return;
        Auction auction = active.get(0);
        User seller = auction.getItem().getSeller();
        boolean result = auctionService.placeBid(auction, seller, 99999.0);
        assertFalse(result, "Seller should not be able to bid on own item");
    }

    @Test
    @Order(5)
    void testPlaceBidInsufficientAmount() {
        List<Auction> active = auctionService.getActiveAuctions();
        if (active.isEmpty()) return;
        Auction auction = active.get(0);
        List<User> users = userService.getAllUsers();
        User bidder = null;
        for (User u : users) {
            if (u.getId() != auction.getItem().getSeller().getId()) {
                bidder = u;
                break;
            }
        }
        if (bidder == null) return;
        // bid below starting price
        boolean result = auctionService.placeBid(auction, bidder, 0.01);
        assertFalse(result, "Bid below minimum should be rejected");
    }

    @Test
    @Order(6)
    void testPlaceBidNullAuction() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) return;
        boolean result = auctionService.placeBid(null, users.get(0), 100.0);
        assertFalse(result, "Should reject null auction");
    }

    @Test
    @Order(7)
    void testPlaceBidNullBidder() {
        List<Auction> active = auctionService.getActiveAuctions();
        if (active.isEmpty()) return;
        boolean result = auctionService.placeBid(active.get(0), null, 100.0);
        assertFalse(result, "Should reject null bidder");
    }

    @Test
    @Order(8)
    void testGetAuctionsByEndDateRange() {
        LocalDateTime from = LocalDateTime.now().minusYears(2);
        LocalDateTime to = LocalDateTime.now().plusYears(5);
        List<Auction> result = auctionService.getAuctionsByEndDateRange(from, to);
        assertNotNull(result, "Should return list");
    }

    @Test
    @Order(9)
    void testProcessDueAuctions() {
        int processed = auctionService.processDueAuctions();
        assertTrue(processed >= 0, "Processed count should be non-negative");
    }

    @Test
    @Order(10)
    void testCancelNonActiveAuction() {
        List<Auction> sold = auctionService.getAuctionsByStatus(Auction.SOLD);
        if (sold.isEmpty()) return;
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) return;
        boolean result = auctionService.cancelAuction(sold.get(0), users.get(0));
        assertFalse(result, "Should not cancel a non-ACTIVE auction");
    }
}
