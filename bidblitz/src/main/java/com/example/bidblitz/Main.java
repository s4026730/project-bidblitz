package com.example.bidblitz;

import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("guest-main-view.fxml"));
        Scene mainScene = new Scene(fxmlLoader.load());
        mainScene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
        InputStream iconStream = getClass().getResourceAsStream("/applicationImages/bidblitz-icon.png");

        if (iconStream != null){
            Image icon = new Image(iconStream);
            stage.getIcons().add(icon);
        }

        else{
            System.out.println("Error: Incorrect Image Path.");
        }
        stage.setTitle("BidBlitz");
        stage.setScene(mainScene);
        stage.show();
    }
}
