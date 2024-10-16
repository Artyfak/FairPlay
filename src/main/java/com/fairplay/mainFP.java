package com.fairplay;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class mainFP extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxml = new FXMLLoader(mainFP.class.getResource("fairplay-view.fxml"));
        Scene scene = new Scene(fxml.load(), 600, 400);
        stage.setScene(scene);
        stage.setTitle("FairPlay Konštiak");
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}