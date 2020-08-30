package com.kodilla.game;

import com.kodilla.game.flow.GameFlow;
import com.kodilla.game.graphic.SignDrawer;
import com.kodilla.game.interaction.ConversionKeyToPosition;
import com.kodilla.game.logic.ComputersLogic;
import com.kodilla.game.logic.GameState;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private final GameState gameState = new GameState();
    private final SignDrawer signDrawer = new SignDrawer();
    private final ComputersLogic computersLogic = new ComputersLogic(gameState);
    private final GameFlow gameFlow = new GameFlow(signDrawer, gameState, computersLogic);
    private final ConversionKeyToPosition conversion = new ConversionKeyToPosition();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(signDrawer.getGrid(), 800, 600);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyPressed(e -> gameFlow.handleUserChoice(conversion.convertKeyToPosition(e)));
    }
}
