package com.kodilla.game;

import com.kodilla.game.flow.GameFlow;
import com.kodilla.game.graphic.SignDrawer;
import com.kodilla.game.logic.GameState;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    GameState gameState = new GameState();
    SignDrawer signDrawer = new SignDrawer();
    GameFlow gameFlow = new GameFlow(signDrawer, gameState);


    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(signDrawer.getGrid(), 500, 500);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyPressed(e -> gameFlow.onKeyPressed(e));
    }
}
