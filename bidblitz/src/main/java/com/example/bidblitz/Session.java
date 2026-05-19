package com.example.bidblitz;

public class Session {
    private static UserEntity currentUser;
    public static UserEntity getCurrentUser() {
        return currentUser;
    }
    public static void setCurrentUser(UserEntity user) {
        currentUser = user;
    }
}
