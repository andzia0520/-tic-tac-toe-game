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
        switch (event.getCode()) {
            case DIGIT1:
                state.addSign(1, new Cross());
                break;
            case DIGIT2:
                state.addSign(2, new Cross());
                break;
            case DIGIT3:
                state.addSign(3, new Cross());
                break;
            case DIGIT4:
                state.addSign(4, new Cross());
                break;
            case DIGIT5:
                state.addSign(5, new Cross());
                break;
            case DIGIT6:
                state.addSign(6, new Cross());
                break;
            case DIGIT7:
                state.addSign(7, new Cross());
                break;
            case DIGIT8:
                state.addSign(8, new Cross());
                break;
            case DIGIT9:
                state.addSign(9, new Cross());
                break;
        }

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

    //private void addSign(KeyEvent event, )
}





