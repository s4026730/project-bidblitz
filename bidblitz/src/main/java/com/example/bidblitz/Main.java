package com.example.bidblitz;

import com.example.bidblitz.util.DatabaseUtil;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        SampleDataLoader.loadSampleData();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("guest-main-view.fxml"));
        Parent root = fxmlLoader.load();
        MainController controller = fxmlLoader.getController();
        controller.slideshowSystem();
        Scene mainScene = new Scene(root);
        InputStream iconStream = getClass().getResourceAsStream("/image/bidblitz-icon.png");

        if (iconStream != null) {
            Image icon = new Image(iconStream);
            stage.getIcons().add(icon);
        } else {
            System.out.println("Error: Incorrect Image Path.");
        }

        stage.setTitle("BidBlitz");
        stage.setScene(mainScene);
        stage.setOnCloseRequest(event -> DatabaseUtil.close());
        stage.show();
    }
}