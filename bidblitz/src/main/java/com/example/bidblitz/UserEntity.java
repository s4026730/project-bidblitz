package com.example.bidblitz;
import java.math.BigDecimal;
public class UserEntity {
    private String avatarPath;
    private String username;
    private BigDecimal balance;

    public UserEntity(String username, BigDecimal balance, String avatarPath){

        this.username = username;
        this.balance = balance;
        this.avatarPath = avatarPath;

    }
    public String getAvatarPath() {
        return avatarPath;
    }

    public String getUsername() {
        return username;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
