package com.kodilla.game;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        SignDrawer signDrawer = new SignDrawer();

        GameState state = new GameState(signDrawer);

        Scene scene = new Scene((Parent) signDrawer.getGrid(), 500, 500);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case DIGIT1:
                        state.addSign(1, new Cross());
                        break;
                    case DIGIT2:
                        state.addSign(2, new Circle());
                        break;
                    case DIGIT3:
                        state.addSign(3, new Cross());
                        break;
                    case DIGIT4:
                        state.addSign(4, new Cross());
                        break;
                    case DIGIT5:
                        state.addSign(5, new Circle());
                        break;
                    case DIGIT6:
                        state.addSign(6, new Cross());
                        break;
                    case DIGIT7:
                        state.addSign(7, new Circle());
                        break;
                    case DIGIT8:
                        state.addSign(8, new Cross());
                        break;
                    case DIGIT9:
                        state.addSign(9, new Circle());
                        break;
                }
            }
        });
    }
}




