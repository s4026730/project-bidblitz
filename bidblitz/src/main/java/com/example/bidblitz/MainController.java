package com.example.bidblitz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    private Stage stage;
    private Parent root;
    private Scene demonstratedScene;
    @FXML
    private TextField searchBar;
    @FXML
    private ListView<String> listView;

    public void switchToGuestHome(ActionEvent event) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("guest-main-view.fxml"));
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
    } //[1] [2] [3]

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
            System.err.println("Could not find guest-auction-view.fxml. Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

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
            System.err.println("Could not find guest-auction-view.fxml. Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

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
            System.err.println("Could not find guest-auction-view.fxml. Check your folder structure!");
            e.printStackTrace();
        }
    }//[1] [2] [3]

    public void switchToGuestSignIn(ActionEvent event) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(""));
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

    public void switchToGuestSignUp(ActionEvent event) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(""));
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
}

