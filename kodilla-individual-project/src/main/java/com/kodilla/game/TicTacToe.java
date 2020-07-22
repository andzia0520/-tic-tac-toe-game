package com.kodilla.game;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    //private FlowPane signs = new FlowPane(Orientation.HORIZONTAL);

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
                    case DIGIT1:  state.addSign(1, new Cross()); break;
                    case DIGIT2:  state.addSign(2, new Cross()); break;
                    case DIGIT3:  state.addSign(3, new Cross()); break;

                }
            }
        });

        //


    }




}




