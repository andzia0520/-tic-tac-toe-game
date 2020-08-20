package com.kodilla.game;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class TicTacToe extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    SignDrawer signDrawer = new SignDrawer();
    GameState state = new GameState(signDrawer);
    ComputersLogic computer = new ComputersLogic(state);

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(signDrawer.getGrid(), 500, 500);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyPressed(this::onKeyPressed);
    }

    private void onKeyPressed(KeyEvent event) {
        Integer position = convertKeyToPosition(event);
        if (position == null || state.isFieldOccupied(position)) {
            System.out.println("niepoprawny ruch");
            return;
        }

        state.addSign(position, new Cross());

        if (state.getGameResult() == GameResult.PLAYER_WON) {
            System.out.println("You won");
            return;
        } else if (state.getGameResult() == GameResult.DRAW) {
            System.out.println("Draw");
            return;
        }
        state.addSign(computer.getComputerTurn(), new Circle());
        if (state.getGameResult() == GameResult.COMPUTER_WON) {
            System.out.println("Computer won");
            return;
        } else if (state.getGameResult() == GameResult.DRAW) {
            System.out.println("Draw");
            return;
        }
    }

    private Integer convertKeyToPosition(KeyEvent event) {
        switch (event.getCode()) {
            case DIGIT1:
                return 1;
            case DIGIT2:
                return 2;
            case DIGIT3:
                return 3;
            case DIGIT4:
                return 4;
            case DIGIT5:
                return 5;
            case DIGIT6:
                return 6;
            case DIGIT7:
                return 7;
            case DIGIT8:
                return 8;
            case DIGIT9:
                return 9;

            default:
                return null;
        }
    }
}