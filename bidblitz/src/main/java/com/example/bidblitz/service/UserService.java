package com.example.bidblitz.service;

/**
 * @author Team 6
 */

import com.example.bidblitz.model.ActivityLog;
import com.example.bidblitz.model.User;
import com.example.bidblitz.repository.ActivityLogRepository;
import com.example.bidblitz.repository.UserRepository;
import java.util.List;

public class UserService {

    private static final double MIN_TOPUP = 5.0;
    private static final double MAX_TOPUP = 10000.0;

    private UserRepository userRepository;
    private ActivityLogRepository logRepository;

    public UserService() {
        this.userRepository = new UserRepository();
        this.logRepository = new ActivityLogRepository();
    }

    public User login(String username, String password) {
        if (username == null || username.isEmpty()) {
            return null;
        }
        if (password == null || password.isEmpty()) {
            return null;
        }
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
            ActivityLog log = new ActivityLog(user, ActivityLog.ACTION_LOGIN, "User", user.getId(), user.getUsername() + " logged in");
            logRepository.add(log);
        }
        return user;
    }

    public boolean addUser(User user) {
        if (!validateUserDetails(user)) {
            return false;
        }

        if (userRepository.isUsernameTaken(user.getUsername())) {
            return false;
        }
        if (userRepository.isEmailTaken(user.getEmail())) {
            return false;
        }
        return userRepository.add(user);
    }

    public boolean updateUser(User user) {
        if (user == null) {
            return false;
        }
        return userRepository.update(user);
    }

    public boolean deleteUser(int userId) {
        return userRepository.delete(userId);
    }

    public User getUserById(int userId) {
        return userRepository.findById(userId);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean requestTopUp(User user, double amount, User actor) {
        // amount must be between $5 and $10,000
        if (amount < MIN_TOPUP || amount > MAX_TOPUP) {
            return false;
        }
        ActivityLog log = new ActivityLog(actor, ActivityLog.ACTION_UPDATE,
                "User", user.getId(),
                "Top-up request of $" + String.format("%.2f", amount) + " submitted by " + user.getUsername());
        logRepository.add(log);
        return true;
    }

    public boolean approveTopUp(User user, double amount, User admin) {
        if (amount < MIN_TOPUP || amount > MAX_TOPUP) {
            return false;
        }
        user.setAccountBalance(user.getAccountBalance() + amount);
        boolean updated = userRepository.update(user);
        if (updated) {
            ActivityLog log = new ActivityLog(admin, ActivityLog.ACTION_UPDATE,
                    "User", user.getId(),
                    "Top-up of $" + String.format("%.2f", amount) + " approved for " + user.getUsername());
            logRepository.add(log);
        }
        return updated;
    }

    public boolean isEmailTaken(String email) {
        return userRepository.isEmailTaken(email);
    }

    public boolean isUsernameTaken(String username) {
        return userRepository.isUsernameTaken(username);
    }

    public boolean validateUserDetails(User user){
        // User object cannot be null
        if(user == null){
            return false;
        }

        // Full name cannot be empty
        if(user.getFullName() == null ||
                user.getFullName().isBlank()){
            return false;
        }

        // Username cannot be empty
        if(user.getUsername() == null ||
                user.getUsername().isBlank()){
            return false;
        }

        // Email cannot be empty
        if(user.getEmail() == null ||
                user.getEmail().isBlank()){
            return false;
        }

        // Email must contain '@'
        if(!user.getEmail().contains("@")){
            return false;
        }

        // Phone number cannot be empty
        if(user.getPhone() == null ||
                user.getPhone().isBlank()){
            return false;
        }
        return true;
    }
}
