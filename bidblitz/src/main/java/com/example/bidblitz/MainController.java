package com.example.bidblitz;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    private Label auctionIntro;
    @FXML
    private Label transactionHistoryIntro;
    @FXML
    private TextField searchBar;
    @FXML
    private ListView<String> listView;

    @FXML
    protected void onHelloButtonClick() {
        this.auctionIntro.setText("Welcome to Auction!");
    }

    @FXML
    protected void onTransactionHistoryIntro() {
        this.transactionHistoryIntro.setText("Welcome to Auction!");
    }
}

