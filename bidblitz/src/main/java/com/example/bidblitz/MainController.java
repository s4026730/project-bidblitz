package com.example.bidblitz;

import java.util.Locale;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainController {
    private Parent root;
    private Stage stage;
    private Scene demonstratedScene;
    private String fxmlFile;
    private Image[] bannerImages;
    private int currentIndex = 0;
    private UserEntity currentUser = Session.getCurrentUser();

    @FXML
    private BorderPane rootPane;
    @FXML
    private VBox categoryPanel;
    @FXML
    private TextField searchBar;
    @FXML
    private ListView<String> listView;
    @FXML
    private Button auctionSelections;
    @FXML
    private ImageView banner;
    @FXML
    ImageView accountAvatar;
    @FXML
    private Label accountUsername;
    @FXML
    private Label accountBalance;

    // Guest Pages Navigation & Other Features Codes:
    @FXML
    protected void switchToGuestHome() throws IOException{
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
    protected void switchToGuestAuction() throws IOException{
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
    protected void switchToGuestHelp() throws IOException{
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
    protected void switchToGuestAboutUs() throws IOException{
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
    protected void switchToSignIn() throws IOException{
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
    protected void switchToSignUp() throws IOException{
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
    protected void switchToForgotUsername() throws IOException{
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
    protected void switchToForgotPassword() throws IOException{
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
    protected void switchToUserHome () throws IOException{
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
    protected void switchToUserAuction () throws IOException{
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


    @FXML
    protected void switchToUserHelp() throws IOException{
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
    protected void switchToUserAboutUs () throws IOException{
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
    protected void switchToProfile () throws IOException{
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
    protected void switchToInventory () throws IOException{
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
    protected void switchToBalance () throws IOException{
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
    protected void switchToTransactionHistory () throws IOException{
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
    protected void switchToSettings () throws IOException{
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

    // Auction Functionality Codes (WIP):
    protected void handleAuctionSelection (ActionEvent event) throws IOException{

        auctionSelections.getStyleClass().remove("underlinedText");
        Button clickedButton = (Button) event.getSource();
        clickedButton.getStyleClass().add("underlinedText");
    }

    // Slideshow Feature Codes:
    protected void slideshowSystem() {

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

    protected void setAccountInfo(){
        setAccountAvatar();
        setAccountUsername();
        setAccountBalance();
    }

    private void setAccountAvatar(){
        if(currentUser == null){return;}
        Image avatarImage = new Image(getClass().getResourceAsStream(currentUser.getAvatarPath()));
        accountAvatar.setImage(avatarImage);
    }
    private void setAccountUsername(){
        if(currentUser == null){return;}
        accountUsername.setText(currentUser.getUsername());
    }

    private void setAccountBalance(){
        if(currentUser == null){return;}
        BigDecimal userBalance = currentUser.getBalance();
        NumberFormat balanceFormatter = NumberFormat.getNumberInstance(Locale.US);
        accountBalance.setText(balanceFormatter.format(userBalance));
    }

    @FXML
    private void toggleCategoryPanel() {
        boolean isVisible = categoryPanel.isVisible();

        categoryPanel.setVisible(!isVisible);
        categoryPanel.setManaged(!isVisible);
        if(!isVisible){
            categoryPanel.toFront();
        }
    }

}

