package com.kodilla.game;

import com.kodilla.game.flow.GameFlow;
import com.kodilla.game.graphic.SignDrawer;
import com.kodilla.game.logic.ComputersLogic;
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
    ComputersLogic computersLogic = new ComputersLogic(gameState);
    GameFlow gameFlow = new GameFlow(signDrawer, gameState, computersLogic);

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(signDrawer.getGrid(), 500, 500);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyPressed(e -> gameFlow.handleKey(e));
    }
}
