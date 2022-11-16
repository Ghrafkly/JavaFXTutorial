package com.example.keeptoo;

import com.example.keeptoo.controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class HelloApplication extends Application {
    double x, y = 0;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fxml/main.fxml")));
        Scene scene = new Scene(root);
        MainController.pStage = stage;



//        stage.initStyle(StageStyle.UNDECORATED);

        root.setOnMouseClicked(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        stage.setScene(scene);
        for (Screen screen : Screen.getScreens()) {
            Rectangle2D bounds = screen.getBounds();
            double x = bounds.getMinX() + (bounds.getWidth() - scene.getWidth()) * 0.2;
            double y = bounds.getMinY() + (bounds.getHeight() - scene.getHeight()) * 0.2;
            stage.setX(x);
            stage.setY(y);
        }
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}