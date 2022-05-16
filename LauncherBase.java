package com.eryeodev.erylib.ui;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;

public class LauncherBase {

    private static double xOffset = 0;
    private static double yOffset = 0;

    public static void setMovable(Pane layout, Stage stage, Boolean movable) {
        if(movable = true) {
            layout.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });

            layout.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                }
            });
        }
    }

    public static void createWindow(Pane layout, Stage stage, Scene scene, StageStyle stageStyle, String title, int width, int height) {
        layout.setPrefSize(width, height);
        stage.setTitle(title);
        stage.initStyle(stageStyle);
        stage.setScene(scene);
        stage.show();
    }

    public static void addBackground(Pane layout, String urlBackground, Boolean booleanBackground) {
        if(booleanBackground = true) {
            Image background = new Image(urlBackground);
            BackgroundImage LauncherBackground = new BackgroundImage(background, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background launcherBackground = new Background(LauncherBackground);
            layout.setBackground(launcherBackground);
        }
    }
}
