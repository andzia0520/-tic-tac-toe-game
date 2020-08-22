package com.kodilla.game;

import com.kodilla.game.gameLogic.*;
import com.kodilla.game.graphic.SignDrawer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    SignDrawer signDrawer = new SignDrawer();
    GameFlow gameFlow = new GameFlow();

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(signDrawer.getGrid(), 500, 500);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyPressed(e -> gameFlow.onKeyPressed(e));
    }
}
