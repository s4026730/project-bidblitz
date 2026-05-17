package com.example.bidblitz;

import java.io.IOException;
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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainController {
    private Parent root;
    private Stage stage;
    private Scene demonstratedScene;
    private String fxmlFile;
    private Image[] bannerImages;
    private int currentIndex = 0;
    @FXML
    private BorderPane rootPane;
    @FXML
    private TextField searchBar;
    @FXML
    private ListView<String> listView;
    @FXML
    private Button auctionSelections;
    @FXML
    private ImageView banner;

    // Guest Pages Navigation & Other Features Codes:
    @FXML
    public void switchToGuestHome(ActionEvent event) throws IOException{
        fxmlFile="guest-main-view.fxml";
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            MainController controller = fxmlLoader.getController();
            controller.slideshowSystem();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find "+ fxmlFile +". Check your folder structure!");
            e.printStackTrace();
        }
    } //[1] [2] [3]

    @FXML
    public void switchToGuestAuction(ActionEvent event) throws IOException{
        fxmlFile="guest-auction-view.fxml";
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find "+ fxmlFile +". Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    @FXML
    public void switchToGuestHelp(ActionEvent event) throws IOException{
        fxmlFile="guest-help-view.fxml";
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find "+ fxmlFile +". Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    @FXML
    public void switchToGuestAboutUs(ActionEvent event) throws IOException{
        fxmlFile="guest-about-us-view.fxml";
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find "+ fxmlFile +". Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    @FXML
    public void switchToSignIn(ActionEvent event) throws IOException{
        fxmlFile="sign-in-view.fxml";
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find "+ fxmlFile +". Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    @FXML
    public void switchToSignUp(ActionEvent event) throws IOException{
        fxmlFile="sign-up-view.fxml";
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find "+ fxmlFile +". Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    @FXML
    public void switchToForgotUsername(ActionEvent event) throws IOException{
        fxmlFile="forgot-username-view.fxml";
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find "+ fxmlFile +". Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    @FXML
    public void switchToForgotPassword(ActionEvent event) throws IOException{
        fxmlFile="forgot-password-view.fxml";
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find "+ fxmlFile +". Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    // User Pages Navigation & Other Features Codes:
    @FXML
    public void switchToUserHome (ActionEvent event) throws IOException{
        fxmlFile="user-main-view.fxml";
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            MainController controller = fxmlLoader.getController();
            controller.slideshowSystem();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find "+ fxmlFile +". Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    @FXML
    public void switchToUserAuction (ActionEvent event) throws IOException{
        fxmlFile="user-auction-view.fxml";
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find "+ fxmlFile +". Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    /*
    @FXML
    public void switchToUserCategory (ActionEvent event) throws IOException {
        fxmlFile = "user-category-view.fxml";
        try {
        } catch (IOException e) {
        }
    }
     */

    @FXML
    public void switchToUserHelp(ActionEvent event) throws IOException{
        fxmlFile ="user-help-view.fxml";
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find "+ fxmlFile +". Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    @FXML
    public void switchToUserAboutUs (ActionEvent event) throws IOException{
        fxmlFile ="user-about-us-view.fxml";
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find "+ fxmlFile +". Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    @FXML
    public void switchToProfile (ActionEvent event) throws IOException{
        fxmlFile ="profile-view.fxml";
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find "+ fxmlFile +". Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    @FXML
    public void switchToInventory (ActionEvent event) throws IOException{
        fxmlFile ="inventory-view.fxml";
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find "+ fxmlFile +". Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    @FXML
    public void switchToBalance (ActionEvent event) throws IOException{
        fxmlFile ="balance-view.fxml";
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find "+ fxmlFile +". Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    @FXML
    public void switchToTransactionHistory (ActionEvent event) throws IOException{
        fxmlFile ="transaction-history-view.fxml";
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find "+ fxmlFile +". Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    @FXML
    public void switchToSettings (ActionEvent event) throws IOException{
        fxmlFile ="settings-view.fxml";
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        }
        catch(IOException e){
            System.err.println("Could not find "+ fxmlFile +". Check your folder structure!");
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

