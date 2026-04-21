package com.example.bidblitz;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("guest-main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1710, 1000);
        scene.getStylesheets().add(getClass().getResource("/css/General.css").toExternalForm());
        stage.setTitle("BitBlitz");
        stage.setScene(scene);
        stage.show();
    }
}
