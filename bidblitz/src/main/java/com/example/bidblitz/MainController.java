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
import com.example.bidblitz.model.User;
import com.example.bidblitz.service.UserService;
import java.math.BigDecimal;
import javafx.scene.control.PasswordField;
import com.example.bidblitz.model.Auction;
import com.example.bidblitz.model.ActivityLog;
import com.example.bidblitz.model.Category;
import com.example.bidblitz.repository.ActivityLogRepository;
import com.example.bidblitz.repository.CategoryRepository;
import com.example.bidblitz.service.AuctionService;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;
import java.util.stream.Collectors;
import com.example.bidblitz.model.Category;
import com.example.bidblitz.model.Payment;
import com.example.bidblitz.repository.CategoryRepository;
import com.example.bidblitz.repository.PaymentRepository;


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
    //sign in, sign up
    @FXML
    private Label accountUsername;
    @FXML
    private Label accountBalance;
    @FXML
    private TextField signinUsername;
    @FXML
    private PasswordField signinPassword;
    @FXML
    private Button signinButton;
    @FXML
    private TextField signupUsername;
    @FXML
    private TextField signupEmail;
    @FXML
    private PasswordField signupPassword;
    @FXML
    private Button signupButton;
    @FXML
    private Label signupErrorLabel;
    //profile
    @FXML private ImageView profileAvatar;
    @FXML private Label profileFullName;
    @FXML private Label profileUsername;
    @FXML private Label profileEmail;
    @FXML private Label profilePhone;
    @FXML private Label profileDob;
    @FXML private Label profileRole;
    @FXML private Label profileBalanceLabel;
    @FXML private Label profileRating;
    //admin
    // Dashboard
    @FXML private Label adminTotalUsers;
    @FXML private Label adminActiveAuctions;
    @FXML private Label adminPendingTopUps;
    @FXML private Label adminTotalCategories;

    // Auctions table
    @FXML private TableView<Auction> adminAuctionTable;
    @FXML private TableColumn<Auction, Integer> auctionIdCol;
    @FXML private TableColumn<Auction, String> auctionItemCol;
    @FXML private TableColumn<Auction, String> auctionSellerCol;
    @FXML private TableColumn<Auction, String> auctionStatusCol;
    @FXML private TableColumn<Auction, Double> auctionHighestBidCol;
    @FXML private TableColumn<Auction, String> auctionEndDateCol;
    @FXML private TableColumn<Auction, String> auctionWinnerCol;
    @FXML private Label auctionStatusLabel;

    // Users table
    @FXML private TableView<User> adminUserTable;
    @FXML private TableColumn<User, Integer> userIdCol;
    @FXML private TableColumn<User, String> userFullNameCol;
    @FXML private TableColumn<User, String> userUsernameCol;
    @FXML private TableColumn<User, String> userEmailCol;
    @FXML private TableColumn<User, String> userRoleCol;
    @FXML private TableColumn<User, Double> userBalanceCol;
    @FXML private TableColumn<User, Double> userRatingCol;
    @FXML private Label userStatusLabel;

    // Top-up table
    @FXML private TableView<ActivityLog> topUpTable;
    @FXML private TableColumn<ActivityLog, Integer> topUpIdCol;
    @FXML private TableColumn<ActivityLog, String> topUpUsernameCol;
    @FXML private TableColumn<ActivityLog, String> topUpAmountCol;
    @FXML private TableColumn<ActivityLog, String> topUpDateCol;
    @FXML private TableColumn<ActivityLog, String> topUpStatusCol;
    @FXML private TableColumn<ActivityLog, String> topUpDescriptionCol;
    @FXML private Label topUpStatusLabel;

    // Activity log table
    @FXML private TableView<ActivityLog> activityLogTable;
    @FXML private TableColumn<ActivityLog, Integer> logIdCol;
    @FXML private TableColumn<ActivityLog, String> logTimestampCol;
    @FXML private TableColumn<ActivityLog, String> logActorCol;
    @FXML private TableColumn<ActivityLog, String> logActionCol;
    @FXML private TableColumn<ActivityLog, String> logTargetCol;
    @FXML private TableColumn<ActivityLog, String> logDescriptionCol;

    // Categories
    @FXML private TableView<Category> adminCategoryTable;
    @FXML private TableColumn<Category, Integer> categoryIdCol;
    @FXML private TableColumn<Category, String> categoryNameCol;
    @FXML private TableColumn<Category, String> categoryDescriptionCol;
    @FXML private TableColumn<Category, Double> categoryCommissionCol;

    // Payments
    @FXML private TableView<Payment> adminPaymentTable;
    @FXML private TableColumn<Payment, Integer> paymentIdCol;
    @FXML private TableColumn<Payment, String> paymentBuyerCol;
    @FXML private TableColumn<Payment, String> paymentSellerCol;
    @FXML private TableColumn<Payment, String> paymentItemCol;
    @FXML private TableColumn<Payment, Double> paymentTotalCol;
    @FXML private TableColumn<Payment, Double> paymentCommissionCol;
    @FXML private TableColumn<Payment, Double> paymentPayoutCol;
    @FXML private TableColumn<Payment, String> paymentStatusCol;
    @FXML private TableColumn<Payment, String> paymentDateCol;
    //field declaration
    @FXML private TextField newCategoryName;
    @FXML private TextField newCategoryDescription;
    @FXML private TextField newCategoryCommission;
    @FXML private Label categoryStatusLabel;
    @FXML private Label paymentStatusLabel;

    //settings
    @FXML private TextField settingsFullName;
    @FXML private TextField settingsEmail;
    @FXML private TextField settingsPhone;
    @FXML private TextField settingsDob;
    @FXML private PasswordField settingsCurrentPassword;
    @FXML private PasswordField settingsNewPassword;
    @FXML private PasswordField settingsConfirmPassword;
    @FXML private Label settingsStatusLabel;

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
    protected void switchToSettings() throws IOException {
        fxmlFile = "settings-view.fxml";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            MainController controller = fxmlLoader.getController();
            controller.setAccountInfo();
            controller.loadSettingsData();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
    @FXML
    protected void handleSignIn() throws IOException {
        String username = signinUsername.getText().trim();
        String password = signinPassword.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Please enter username and password.");
            return;
        }

        UserService userService = new UserService();
        User user = userService.login(username, password);

        if (user == null) {
            System.out.println("Invalid username or password.");
            signinUsername.setStyle("-fx-border-color: red;");
            signinPassword.setStyle("-fx-border-color: red;");
            return;
        }

        // convert User to UserEntity and store in Session
        UserEntity userEntity = new UserEntity(
                user.getUsername(),
                BigDecimal.valueOf(user.getAccountBalance()),
                "/image/default-avatar.png"
        );
        Session.setCurrentUser(userEntity);

        // load user home and set account info
        // route based on role
        if (user.getRole().equals(User.ROLE_SYSTEM_ADMIN) ||
                user.getRole().equals(User.ROLE_AUCTION_ADMIN)) {
            fxmlFile = "admin-main-view.fxml";
        } else {
            fxmlFile = "user-main-view.fxml";
        }
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        root = fxmlLoader.load();
        MainController controller = fxmlLoader.getController();

        if (user.getRole().equals(User.ROLE_SYSTEM_ADMIN) ||
                user.getRole().equals(User.ROLE_AUCTION_ADMIN)) {
            controller.setAccountInfo();
            controller.loadAdminDashboard(); // admin only
        } else {
            controller.slideshowSystem(); // user only
            controller.setAccountInfo();
        }

        stage = (Stage) rootPane.getScene().getWindow();
        demonstratedScene = new Scene(root, 1710, 1000);
        demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
        stage.setScene(demonstratedScene);
        stage.show();
    }
    @FXML
    protected void handleLogOut() throws IOException {
        Session.setCurrentUser(null);
        switchToGuestHome();
    }
    @FXML
    protected void handleSignUp() throws IOException {
        String username = signupUsername.getText().trim();
        String email = signupEmail.getText().trim();
        String password = signupPassword.getText().trim();

        // reset styles
        signupUsername.setStyle("");
        signupEmail.setStyle("");
        signupErrorLabel.setVisible(false);

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            signupErrorLabel.setText("Please fill in all fields.");
            signupErrorLabel.setVisible(true);
            return;
        }

        if (password.length() < 8) {
            signupPassword.setStyle("-fx-border-color: red;");
            signupErrorLabel.setText("Password must be at least 8 characters.");
            signupErrorLabel.setVisible(true);
            return;
        }
        if (!email.contains("@") || !email.contains(".")) {
            signupEmail.setStyle("-fx-border-color: red;");
            signupErrorLabel.setText("Invalid email format. Please use example@domain.com");
            signupErrorLabel.setVisible(true);
            return;
        }

        UserService userService = new UserService();

        if (userService.isUsernameTaken(username)) {
            signupUsername.setStyle("-fx-border-color: red;");
            signupErrorLabel.setText("Username already taken. Please choose another.");
            signupErrorLabel.setVisible(true);
            return;
        }

        if (userService.isEmailTaken(email)) {
            signupEmail.setStyle("-fx-border-color: red;");
            signupErrorLabel.setText("Email already in use. Please use another email.");
            signupErrorLabel.setVisible(true);
            return;
        }

        User newUser = new User(
                username,
                java.time.LocalDateTime.now(),
                email,
                "",
                username,
                password,
                User.ROLE_USER,
                0.0
        );

        boolean added = userService.addUser(newUser);
        if (added) {
            System.out.println("Account created successfully!");
            switchToSignIn();
        } else {
            signupErrorLabel.setText("Failed to create account. Please try again.");
            signupErrorLabel.setVisible(true);
        }
    }
    @FXML
    public void initialize() {
        if (profileFullName != null) {
            loadProfileData();
        }
        setAccountInfo();
    }

    private void loadProfileData() {
        UserEntity currentUser = Session.getCurrentUser();
        if (currentUser == null) return;

        UserService userService = new UserService();
        User user = userService.getUserByUsername(currentUser.getUsername());
        if (user == null) return;

        profileFullName.setText(user.getFullName());
        profileUsername.setText(user.getUsername());
        profileEmail.setText(user.getEmail());
        profilePhone.setText(user.getPhone() != null ? user.getPhone() : "N/A");
        profileDob.setText(user.getDateOfBirth() != null ?
                user.getDateOfBirth().toLocalDate().toString() : "N/A");
        profileRole.setText(user.getRole());
        profileBalanceLabel.setText("$" + String.format("%.2f", user.getAccountBalance()));
        profileRating.setText(String.format("%.1f", user.getRating()) + " / 5.0");
    }
    @FXML
    protected void switchToAdminHome() throws IOException {
        fxmlFile = "admin-main-view.fxml";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            MainController controller = fxmlLoader.getController();
            controller.setAccountInfo();
            controller.loadAdminDashboard();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        } catch (IOException e) {
            System.err.println("Could not load admin-main-view.fxml");
            e.printStackTrace();
        }
    }

    @FXML
    protected void switchToAdminUsers() throws IOException {
        fxmlFile = "admin-users-view.fxml";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            MainController controller = fxmlLoader.getController();
            controller.setAccountInfo();
            controller.loadAdminUsers();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void switchToAdminAuctions() throws IOException {
        fxmlFile = "admin-auctions-view.fxml";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            MainController controller = fxmlLoader.getController();
            controller.setAccountInfo();
            controller.loadAdminAuctions();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void switchToAdminTopUp() throws IOException {
        fxmlFile = "admin-topup-view.fxml";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            MainController controller = fxmlLoader.getController();
            controller.setAccountInfo();
            controller.loadAdminTopUp();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void switchToAdminCategories() throws IOException {
        fxmlFile = "admin-categories-view.fxml";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            MainController controller = fxmlLoader.getController();
            controller.setAccountInfo();
            controller.loadAdminCategories(); // add this
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void switchToAdminPayments() throws IOException {
        fxmlFile = "admin-payments-view.fxml";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            MainController controller = fxmlLoader.getController();
            controller.setAccountInfo();
            controller.loadAdminPayments(); // add this
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    protected void switchToAdminActivityLog() throws IOException {
        fxmlFile = "admin-activity-log-view.fxml";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            root = fxmlLoader.load();
            MainController controller = fxmlLoader.getController();
            controller.setAccountInfo();
            controller.loadActivityLog();
            stage = (Stage) rootPane.getScene().getWindow();
            demonstratedScene = new Scene(root, 1710, 1000);
            demonstratedScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
            stage.setScene(demonstratedScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void switchToAdminProfile() throws IOException {
        switchToProfile();
    }
    public void loadAdminDashboard() {
        try {
            UserService userService = new UserService();
            AuctionService auctionService = new AuctionService();
            CategoryRepository catRepo = new CategoryRepository();
            ActivityLogRepository logRepo = new ActivityLogRepository();

            if (adminTotalUsers != null)
                adminTotalUsers.setText(String.valueOf(userService.getAllUsers().size()));
            if (adminActiveAuctions != null)
                adminActiveAuctions.setText(String.valueOf(auctionService.getActiveAuctions().size()));
            if (adminTotalCategories != null)
                adminTotalCategories.setText(String.valueOf(catRepo.findAll().size()));
            if (adminPendingTopUps != null) {
                long pending = logRepo.findAll().stream()
                        .filter(l -> l.getActionType().equals(ActivityLog.ACTION_UPDATE)
                                && l.getDescription().contains("Top-up request"))
                        .count();
                adminPendingTopUps.setText(String.valueOf(pending));
            }
        } catch (Exception e) {
            System.err.println("Error loading dashboard: " + e.getMessage());
        }
    }

    public void loadAdminUsers() {
        try {
            UserService userService = new UserService();
            ObservableList<User> users = FXCollections.observableArrayList(userService.getAllUsers());
            if (adminUserTable != null) {
                userIdCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()).asObject());
                userFullNameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getFullName()));
                userUsernameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getUsername()));
                userEmailCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEmail()));
                userRoleCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getRole()));
                userBalanceCol.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getAccountBalance()).asObject());
                userRatingCol.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getRating()).asObject());
                adminUserTable.setItems(users);
            }
        } catch (Exception e) {
            System.err.println("Error loading users: " + e.getMessage());
        }
    }

    public void loadAdminAuctions() {
        try {
            AuctionService auctionService = new AuctionService();
            ObservableList<Auction> auctions = FXCollections.observableArrayList(auctionService.getAllAuctions());
            if (adminAuctionTable != null) {
                auctionIdCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()).asObject());
                auctionItemCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getItem().getTitle()));
                auctionSellerCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getItem().getSeller().getUsername()));
                auctionStatusCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getStatus()));
                auctionHighestBidCol.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getCurrentHighestBid()).asObject());
                auctionEndDateCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEndDateTime().toString()));
                auctionWinnerCol.setCellValueFactory(c -> new SimpleStringProperty(
                        c.getValue().getWinner() != null ? c.getValue().getWinner().getUsername() : "-"));
                adminAuctionTable.setItems(auctions);
            }
        } catch (Exception e) {
            System.err.println("Error loading auctions: " + e.getMessage());
        }
    }

    public void loadAdminTopUp() {
        try {
            ActivityLogRepository logRepo = new ActivityLogRepository();
            List<ActivityLog> topUps = logRepo.findAll().stream()
                    .filter(l -> l.getDescription() != null && l.getDescription().contains("Top-up request"))
                    .collect(java.util.stream.Collectors.toList());
            ObservableList<ActivityLog> list = FXCollections.observableArrayList(topUps);
            if (topUpTable != null) {
                topUpIdCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()).asObject());
                topUpUsernameCol.setCellValueFactory(c -> new SimpleStringProperty(
                        c.getValue().getActor() != null ? c.getValue().getActor().getUsername() : "-"));
                topUpAmountCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDescription()));
                topUpDateCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getTimestamp().toString()));
                topUpStatusCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getActionType()));
                topUpDescriptionCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDescription()));
                topUpTable.setItems(list);
            }
        } catch (Exception e) {
            System.err.println("Error loading top-ups: " + e.getMessage());
        }
    }

    public void loadActivityLog() {
        try {
            ActivityLogRepository logRepo = new ActivityLogRepository();
            ObservableList<ActivityLog> logs = FXCollections.observableArrayList(logRepo.findAll());
            if (activityLogTable != null) {
                logIdCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()).asObject());
                logTimestampCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getTimestamp().toString()));
                logActorCol.setCellValueFactory(c -> new SimpleStringProperty(
                        c.getValue().getActor() != null ? c.getValue().getActor().getUsername() : "-"));
                logActionCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getActionType()));
                logTargetCol.setCellValueFactory(c -> new SimpleStringProperty(
                        c.getValue().getTargetEntity() + "[" + c.getValue().getTargetId() + "]"));
                logDescriptionCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDescription()));
                activityLogTable.setItems(logs);
            }
        } catch (Exception e) {
            System.err.println("Error loading activity log: " + e.getMessage());
        }
    }
    @FXML
    protected void handleProcessDueAuctions() {
        AuctionService auctionService = new AuctionService();
        int count = auctionService.processDueAuctions();
        if (auctionStatusLabel != null)
            auctionStatusLabel.setText("Processed " + count + " due auctions.");
        loadAdminAuctions();
    }

    @FXML
    protected void handleRefreshAuctions() {
        loadAdminAuctions();
        if (auctionStatusLabel != null)
            auctionStatusLabel.setText("Refreshed.");
    }

    @FXML
    protected void handleCancelAuction() {
        if (adminAuctionTable == null) return;
        Auction selected = adminAuctionTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            if (auctionStatusLabel != null)
                auctionStatusLabel.setText("Please select an auction first.");
            return;
        }
        UserService userService = new UserService();
        User admin = userService.getUserByUsername(Session.getCurrentUser().getUsername());
        AuctionService auctionService = new AuctionService();
        boolean result = auctionService.cancelAuction(selected, admin);
        if (auctionStatusLabel != null)
            auctionStatusLabel.setText(result ? "Auction cancelled." : "Cannot cancel — not ACTIVE.");
        loadAdminAuctions();
    }

    @FXML
    protected void handleAdminDeleteUser() {
        if (adminUserTable == null) return;
        User selected = adminUserTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            if (userStatusLabel != null)
                userStatusLabel.setText("Please select a user first.");
            return;
        }
        UserService userService = new UserService();
        boolean result = userService.deleteUser(selected.getId());
        if (userStatusLabel != null)
            userStatusLabel.setText(result ? "User deleted." : "Failed to delete user.");
        loadAdminUsers();
    }

    @FXML
    protected void handleApproveTopUp() {
        if (topUpTable == null) return;
        ActivityLog selected = topUpTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            if (topUpStatusLabel != null)
                topUpStatusLabel.setText("Please select a request first.");
            return;
        }
        // parse amount from description
        try {
            String desc = selected.getDescription();
            String amountStr = desc.replaceAll("[^0-9.]", "");
            double amount = Double.parseDouble(amountStr.isEmpty() ? "0" : amountStr);
            UserService userService = new UserService();
            User targetUser = selected.getActor();
            User admin = userService.getUserByUsername(Session.getCurrentUser().getUsername());
            boolean result = userService.approveTopUp(targetUser, amount, admin);
            if (topUpStatusLabel != null)
                topUpStatusLabel.setText(result ? "Top-up approved!" : "Failed to approve.");
            loadAdminTopUp();
        } catch (Exception e) {
            if (topUpStatusLabel != null)
                topUpStatusLabel.setText("Error processing approval.");
        }
    }

    @FXML
    protected void handleRejectTopUp() {
        if (topUpTable == null) return;
        ActivityLog selected = topUpTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            if (topUpStatusLabel != null)
                topUpStatusLabel.setText("Please select a request first.");
            return;
        }
        if (topUpStatusLabel != null)
            topUpStatusLabel.setText("Top-up request rejected.");
    }
    public void loadAdminCategories() {
        try {
            CategoryRepository catRepo = new CategoryRepository();
            ObservableList<Category> cats = FXCollections.observableArrayList(catRepo.findAll());
            if (adminCategoryTable != null) {
                categoryIdCol.setCellValueFactory(c -> new SimpleIntegerProperty(((Category)c.getValue()).getId()).asObject());
                categoryNameCol.setCellValueFactory(c -> new SimpleStringProperty(((Category)c.getValue()).getName()));
                categoryDescriptionCol.setCellValueFactory(c -> new SimpleStringProperty(((Category)c.getValue()).getDescription()));
                categoryCommissionCol.setCellValueFactory(c -> new SimpleDoubleProperty(((Category)c.getValue()).getCommissionRate()).asObject());
                adminCategoryTable.setItems(cats);
            }
        } catch (Exception e) {
            System.err.println("Error loading categories: " + e.getMessage());
        }
    }

    public void loadAdminPayments() {
        try {
            PaymentRepository payRepo = new PaymentRepository();
            ObservableList<Payment> payments = FXCollections.observableArrayList(payRepo.findAll());
            if (adminPaymentTable != null) {
                paymentIdCol.setCellValueFactory(c -> new SimpleIntegerProperty(((Payment)c.getValue()).getId()).asObject());
                paymentBuyerCol.setCellValueFactory(c -> new SimpleStringProperty(((Payment)c.getValue()).getBuyer() != null ? ((Payment)c.getValue()).getBuyer().getUsername() : "-"));
                paymentSellerCol.setCellValueFactory(c -> new SimpleStringProperty(((Payment)c.getValue()).getSeller() != null ? ((Payment)c.getValue()).getSeller().getUsername() : "-"));
                paymentItemCol.setCellValueFactory(c -> new SimpleStringProperty(((Payment)c.getValue()).getAuction().getItem().getTitle()));
                paymentTotalCol.setCellValueFactory(c -> new SimpleDoubleProperty(((Payment)c.getValue()).getTotalAmount()).asObject());
                paymentCommissionCol.setCellValueFactory(c -> new SimpleDoubleProperty(((Payment)c.getValue()).getCommissionAmount()).asObject());
                paymentPayoutCol.setCellValueFactory(c -> new SimpleDoubleProperty(((Payment)c.getValue()).getSellerPayout()).asObject());
                paymentStatusCol.setCellValueFactory(c -> new SimpleStringProperty(((Payment)c.getValue()).getStatus()));
                paymentDateCol.setCellValueFactory(c -> new SimpleStringProperty(((Payment)c.getValue()).getPaymentDateTime().toString()));
                adminPaymentTable.setItems(payments);
            }
        } catch (Exception e) {
            System.err.println("Error loading payments: " + e.getMessage());
        }
    }
    @FXML
    protected void handleAddCategory() {
        if (newCategoryName == null) return;
        String name = newCategoryName.getText().trim();
        String desc = newCategoryDescription.getText().trim();
        String commStr = newCategoryCommission.getText().trim();

        if (name.isEmpty() || desc.isEmpty() || commStr.isEmpty()) {
            categoryStatusLabel.setText("Please fill in all fields.");
            return;
        }
        try {
            double commission = Double.parseDouble(commStr);
            CategoryRepository catRepo = new CategoryRepository();
            Category cat = new Category(name, desc, commission);
            boolean result = catRepo.add(cat);
            categoryStatusLabel.setText(result ? "Category added!" : "Failed to add category.");
            newCategoryName.clear();
            newCategoryDescription.clear();
            newCategoryCommission.clear();
            loadAdminCategories();
        } catch (NumberFormatException e) {
            categoryStatusLabel.setText("Commission rate must be a number (e.g. 4.5)");
        }
    }

    @FXML
    protected void handleDeleteCategory() {
        if (adminCategoryTable == null) return;
        Category selected = (Category) adminCategoryTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            categoryStatusLabel.setText("Please select a category first.");
            return;
        }
        CategoryRepository catRepo = new CategoryRepository();
        boolean result = catRepo.delete(selected.getId());
        categoryStatusLabel.setText(result ? "Category deleted." : "Failed to delete category.");
        loadAdminCategories();
    }

    @FXML
    protected void handleMarkPaymentCompleted() {
        if (adminPaymentTable == null) return;
        Payment selected = (Payment) adminPaymentTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            paymentStatusLabel.setText("Please select a payment first.");
            return;
        }
        selected.setStatus(Payment.COMPLETED);
        PaymentRepository payRepo = new PaymentRepository();
        boolean result = payRepo.update(selected);
        paymentStatusLabel.setText(result ? "Payment marked as COMPLETED." : "Failed to update.");
        loadAdminPayments();
    }

    @FXML
    protected void handleMarkPaymentFailed() {
        if (adminPaymentTable == null) return;
        Payment selected = (Payment) adminPaymentTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            paymentStatusLabel.setText("Please select a payment first.");
            return;
        }
        selected.setStatus(Payment.FAILED);
        PaymentRepository payRepo = new PaymentRepository();
        boolean result = payRepo.update(selected);
        paymentStatusLabel.setText(result ? "Payment marked as FAILED." : "Failed to update.");
        loadAdminPayments();
    }
    public void loadSettingsData() {
        UserEntity currentUser = Session.getCurrentUser();
        if (currentUser == null) return;
        UserService userService = new UserService();
        User user = userService.getUserByUsername(currentUser.getUsername());
        if (user == null) return;

        if (settingsFullName != null) settingsFullName.setText(user.getFullName());
        if (settingsEmail != null) settingsEmail.setText(user.getEmail());
        if (settingsPhone != null) settingsPhone.setText(user.getPhone() != null ? user.getPhone() : "");
        if (settingsDob != null) settingsDob.setText(
                user.getDateOfBirth() != null ? user.getDateOfBirth().toLocalDate().toString() : "");
    }
    @FXML
    protected void handleSaveSettings() {
        UserEntity currentUser = Session.getCurrentUser();
        if (currentUser == null) return;

        UserService userService = new UserService();
        User user = userService.getUserByUsername(currentUser.getUsername());
        if (user == null) return;

        // validate current password
        String currentPwd = settingsCurrentPassword.getText().trim();
        if (currentPwd.isEmpty()) {
            settingsStatusLabel.setText("Please enter your current password to save changes.");
            settingsStatusLabel.setStyle("-fx-text-fill: red;");
            return;
        }
        if (!user.getPassword().equals(currentPwd)) {
            settingsStatusLabel.setText("Current password is incorrect.");
            settingsStatusLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        // update fields
        String fullName = settingsFullName.getText().trim();
        String email = settingsEmail.getText().trim();
        String phone = settingsPhone.getText().trim();
        String dob = settingsDob.getText().trim();
        String newPwd = settingsNewPassword.getText().trim();
        String confirmPwd = settingsConfirmPassword.getText().trim();

        if (!fullName.isEmpty()) user.setFullName(fullName);

        if (!email.isEmpty() && !email.equals(user.getEmail())) {
            if (!email.contains("@") || !email.contains(".")) {
                settingsStatusLabel.setText("Invalid email format.");
                settingsStatusLabel.setStyle("-fx-text-fill: red;");
                return;
            }
            if (userService.isEmailTaken(email)) {
                settingsStatusLabel.setText("Email already in use.");
                settingsStatusLabel.setStyle("-fx-text-fill: red;");
                return;
            }
            user.setEmail(email);
        }

        if (!phone.isEmpty()) user.setPhone(phone);

        if (!dob.isEmpty()) {
            try {
                user.setDateOfBirth(java.time.LocalDate.parse(dob).atStartOfDay());
            } catch (Exception e) {
                settingsStatusLabel.setText("Invalid date format. Use YYYY-MM-DD.");
                settingsStatusLabel.setStyle("-fx-text-fill: red;");
                return;
            }
        }

        if (!newPwd.isEmpty()) {
            if (newPwd.length() < 8) {
                settingsStatusLabel.setText("New password must be at least 8 characters.");
                settingsStatusLabel.setStyle("-fx-text-fill: red;");
                return;
            }
            if (!newPwd.equals(confirmPwd)) {
                settingsStatusLabel.setText("New passwords do not match.");
                settingsStatusLabel.setStyle("-fx-text-fill: red;");
                return;
            }
            user.setPassword(newPwd);
        }

        boolean result = userService.updateUser(user);
        if (result) {
            settingsStatusLabel.setText("Settings saved successfully!");
            settingsStatusLabel.setStyle("-fx-text-fill: green;");
            settingsCurrentPassword.clear();
            settingsNewPassword.clear();
            settingsConfirmPassword.clear();
        } else {
            settingsStatusLabel.setText("Failed to save settings.");
            settingsStatusLabel.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    protected void handleDeleteAccount() {
        UserEntity currentUser = Session.getCurrentUser();
        if (currentUser == null) return;
        UserService userService = new UserService();
        User user = userService.getUserByUsername(currentUser.getUsername());
        if (user == null) return;
        boolean result = userService.deleteUser(user.getId());
        if (result) {
            Session.setCurrentUser(null);
            try {
                switchToGuestHome();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            settingsStatusLabel.setText("Failed to delete account.");
            settingsStatusLabel.setStyle("-fx-text-fill: red;");
        }
    }


}

