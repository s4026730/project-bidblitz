package com.example.bidblitz;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MainController {
    private Stage stage;
    private Parent root;
    private Scene demonstratedScene;
    @FXML
    private TextField searchBar;
    @FXML
    private ListView<String> listView;
    @FXML
    private Button auctionSelections;

    @FXML
    private ImageView banner;
    private Image[] bannerImages;
    private int currentIndex = 0;

    // Guest Pages Navigation & Other Features Codes:
    @FXML
    public void switchToGuestHome(ActionEvent event) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("guest-main-view.fxml"));
            Parent root = fxmlLoader.load();
            MainController controller = fxmlLoader.getController();
            controller.slideshowSystem();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find guest-main-view.fxml. Check your folder structure!");
            e.printStackTrace();
        }
    } //[1] [2] [3]

    @FXML
    public void switchToGuestAuction(ActionEvent event) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("guest-auction-view.fxml"));
            Parent root = fxmlLoader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find guest-auction-view.fxml. Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    @FXML
    public void switchToGuestCategory(ActionEvent event) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("guest-category-view.fxml"));
            Parent root = fxmlLoader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find guest-category-view.fxml. Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    @FXML
    public void switchToGuestHelp(ActionEvent event) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("guest-help-view.fxml"));
            Parent root = fxmlLoader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find guest-help-view.fxml. Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    @FXML
    public void switchToGuestAboutUs(ActionEvent event) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("guest-about-us-view.fxml"));
            Parent root = fxmlLoader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find guest-about-us-view.fxml. Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    @FXML
    public void switchToSignIn(ActionEvent event) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("sign-in-view.fxml"));
            Parent root = fxmlLoader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find sign-in-view.fxml. Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    @FXML
    public void switchToSignUp(ActionEvent event) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("sign-up-view.fxml"));
            Parent root = fxmlLoader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find sign-up-view.fxml. Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    @FXML
    public void switchToForgotUsername(ActionEvent event) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("forgot-username-view.fxml"));
            Parent root = fxmlLoader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find forgot-username-view.fxml. Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    @FXML
    public void switchToForgotPassword(ActionEvent event) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("forgot-password-view.fxml"));
            Parent root = fxmlLoader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find forgot-password-view.fxml. Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    // User Pages Navigation & Other Features Codes:
    @FXML
    public void switchToUserHome (ActionEvent event) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("user-main-view.fxml"));
            Parent root = fxmlLoader.load();
            MainController controller = fxmlLoader.getController();
            controller.slideshowSystem();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find forgot-password-view.fxml. Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    @FXML
    public void switchToUserAuction (ActionEvent event) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("user-auction-view.fxml"));
            Parent root = fxmlLoader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find forgot-password-view.fxml. Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    public void switchToUserCategory (ActionEvent event) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("user-category-view.fxml"));
            Parent root = fxmlLoader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find forgot-password-view.fxml. Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    public void switchToUserHelp(ActionEvent event) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("user-help-view.fxml"));
            Parent root = fxmlLoader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find guest-help-view.fxml. Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    public void switchToUserAboutUs (ActionEvent event) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("user-about-us-view.fxml"));
            Parent root = fxmlLoader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find forgot-password-view.fxml. Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    public void switchToProfile (ActionEvent event) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("profile-view.fxml"));
            Parent root = fxmlLoader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find forgot-password-view.fxml. Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    public void switchToInventory (ActionEvent event) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("inventory-view.fxml"));
            Parent root = fxmlLoader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find forgot-password-view.fxml. Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    public void switchToTransactionHistory (ActionEvent event) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("transaction-history-view.fxml"));
            Parent root = fxmlLoader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find forgot-password-view.fxml. Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    public void switchToSettings (ActionEvent event) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("settings-view.fxml"));
            Parent root = fxmlLoader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find forgot-password-view.fxml. Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    // Auction Functionality Codes:
    public void handleAuctionSelection (ActionEvent event) throws IOException{

        auctionSelections.getStyleClass().remove("underlinedText");
        Button clickedButton = (Button) event.getSource();
        clickedButton.getStyleClass().add("underlinedText");
    }

    // Slideshow Feature Codes:
    @FXML
    public void slideshowSystem() {

        if (banner == null) {
            return;
        }

        bannerImages = new Image[]{
                new Image(getClass().getResource("/image/bidblitz-icon.png").toExternalForm()),
                new Image(getClass().getResource("/image/google-round-icon.png").toExternalForm())
        };
        currentIndex = 0;

        banner.setImage(bannerImages[currentIndex]);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(5), e -> nextImage())
        );

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.playFromStart();
    }

    private void nextImage() {

        if (banner == null || bannerImages == null) {
            return;
        }

        FadeTransition fadeOut =
                new FadeTransition(Duration.millis(500), banner);

        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);

        fadeOut.setOnFinished(e -> {

            currentIndex++;

            if(currentIndex >= bannerImages.length){
                currentIndex = 0;
            }

            banner.setImage(bannerImages[currentIndex]);

            FadeTransition fadeIn =
                    new FadeTransition(Duration.millis(500), banner);

            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);

            fadeIn.play();
        });

        fadeOut.play();
    }

}

