package com.example.bidblitz;

/**
 * @author Team 6
 */

import com.example.bidblitz.model.User;
import com.example.bidblitz.service.UserService;
import org.junit.jupiter.api.*;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTest {

    private static UserService userService;
    private static User testUser;

    @BeforeAll
    static void setUp() {
        userService = new UserService();
        String unique = String.valueOf(System.currentTimeMillis());
        testUser = new User(
                "Test User",
                LocalDateTime.of(2000, 1, 1, 0, 0),
                "testuser_" + unique + "@email.com",
                "0901234999",
                "testuser_" + unique,
                "password123",
                User.ROLE_USER,
                1000.0
        );
    }

    @Test
    @Order(1)
    void testAddValidUser() {
        boolean result = userService.addUser(testUser);
        assertTrue(result, "Should add valid user successfully");
    }

    @Test
    @Order(2)
    void testAddDuplicateEmail() {
        User duplicate = new User("Duplicate", LocalDateTime.of(2000,1,1,0,0),
                testUser.getEmail(), "0901234000",
                "different_" + System.currentTimeMillis(), "password123", User.ROLE_USER, 500.0);
        assertFalse(userService.addUser(duplicate), "Should reject duplicate email");
    }

    @Test
    @Order(3)
    void testAddDuplicateUsername() {
        User duplicate = new User("Duplicate", LocalDateTime.of(2000,1,1,0,0),
                "different_" + System.currentTimeMillis() + "@email.com", "0901234000",
                testUser.getUsername(), "password123", User.ROLE_USER, 500.0);
        assertFalse(userService.addUser(duplicate), "Should reject duplicate username");
    }


    @Test
    @Order(4)
    void testAddNullUser() {
        boolean result = userService.addUser(null);
        assertFalse(result, "Should reject null user");
    }

    @Test
    @Order(5)
    void testLoginValidCredentials() {
        User loggedIn = userService.login(testUser.getUsername(), "password123");
        assertNotNull(loggedIn, "Should login with valid credentials");
        assertEquals(testUser.getUsername(), loggedIn.getUsername());
    }

    @Test
    @Order(6)
    void testLoginInvalidPassword() {
        User loggedIn = userService.login(testUser.getUsername(), "wrongpassword");
        assertNull(loggedIn, "Should reject invalid password");
    }

    @Test
    @Order(7)
    void testLoginEmptyUsername() {
        User loggedIn = userService.login("", "password123");
        assertNull(loggedIn, "Should reject empty username");
    }

    @Test
    @Order(8)
    void testGetUserByUsername() {
        User found = userService.getUserByUsername(testUser.getUsername());
        assertNotNull(found, "Should find user by username");
        assertEquals(testUser.getUsername(), found.getUsername());
    }

    @Test
    @Order(9)
    void testGetUserByNonExistentUsername() {
        User found = userService.getUserByUsername("nonexistentuser999");
        assertNull(found, "Should return null for non-existent username");
    }

    @Test
    @Order(10)
    void testTopUpValidAmount() {
        User user = userService.getUserByUsername(testUser.getUsername());
        assertNotNull(user);
        double balanceBefore = user.getAccountBalance();
        boolean result = userService.approveTopUp(user, 500.0, user);
        assertTrue(result, "Should approve valid top-up amount");
        assertEquals(balanceBefore + 500.0, user.getAccountBalance(), 0.01);
    }

    @Test
    @Order(11)
    void testTopUpBelowMinimum() {
        User user = userService.getUserByUsername(testUser.getUsername());
        assertNotNull(user);
        boolean result = userService.approveTopUp(user, 3.0, user);
        assertFalse(result, "Should reject top-up below $5");
    }

    @Test
    @Order(12)
    void testTopUpAboveMaximum() {
        User user = userService.getUserByUsername(testUser.getUsername());
        assertNotNull(user);
        boolean result = userService.approveTopUp(user, 15000.0, user);
        assertFalse(result, "Should reject top-up above $10,000");
    }

    @Test
    @Order(13)
    void testGetAllUsers() {
        var users = userService.getAllUsers();
        assertNotNull(users, "Should return list of users");
        assertFalse(users.isEmpty(), "User list should not be empty");
    }

    @Test
    @Order(14)
    void testUpdateUser() {
        User user = userService.getUserByUsername(testUser.getUsername());
        assertNotNull(user);
        user.setFullName("Updated Name");
        boolean result = userService.updateUser(user);
        assertTrue(result, "Should update user successfully");
        User updated = userService.getUserByUsername(testUser.getUsername());
        assertEquals("Updated Name", updated.getFullName());
    }

    @Test
    @Order(15)
    void testDeleteUser() {
        User user = userService.getUserByUsername(testUser.getUsername());
        assertNotNull(user);
        boolean result = userService.deleteUser(user.getId());
        assertTrue(result, "Should delete user successfully");
        User deleted = userService.getUserByUsername(testUser.getUsername());
        assertNull(deleted, "Should return null after deletion");
    }

    @Test
    @Order(16)
    void testInvalidEmail() {
        User invalidUser = new User(
                "Invalid Email",
                LocalDateTime.of(2000,1,1,0,0),
                "invalidemail",
                "0901234567",
                "invalid_" + System.currentTimeMillis(),
                "password123",
                User.ROLE_USER,
                100.0
        );
        boolean result = userService.addUser(invalidUser);
        assertFalse(result, "Should reject invalid email format");
    }

    @Test
    @Order(17)
    void testEmptyUsername() {
        User invalidUser = new User(
                "Empty Username",
                LocalDateTime.of(2000,1,1,0,0),
                "empty@email.com",
                "0901234567",
                "",
                "password123",
                User.ROLE_USER,
                100.0
        );
        boolean result = userService.addUser(invalidUser);
        assertFalse(result, "Should reject empty username");
    }

    @Test
    @Order(18)
    void testEmptyFullName() {
        User invalidUser = new User(
                "",
                LocalDateTime.of(2000,1,1,0,0),
                "fullname@email.com",
                "0901234567",
                "fullname_" + System.currentTimeMillis(),
                "password123",
                User.ROLE_USER,
                100.0
        );
        boolean result = userService.addUser(invalidUser);
        assertFalse(result, "Should reject empty full name");
    }
}
