package com.kodilla.game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TicTacToe extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        SignDrawer signDrawer = new SignDrawer();

        GameState state = new GameState(signDrawer);

        User user = new User();
        Computer computer = new Computer();

        Scene scene = new Scene(signDrawer.getGrid(), 500, 500);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();

        for (int i = 0; i < 9; i++) {
            state.getState(); // ta metoda miałaby wyświetlić aktualny stan planszy
            //ruch gracza;
            if (state.occupiedField == false) {
                state.addSign(3,/* tu nie wiem jak to zrobić żeby program czekał aż
             wpiszę numer klawiaturą */ user.yourTurn());
            } else {
                //komunikat żeby wybrać ponownie pole, bo wybrane jest zajęte iwtedy state.addSign();
            }
            state.getState();
            state.isFinished(); //ta metoda sprawdza czy gra została zakończona, jeśli nie kolejny krok
            //ruch komputera;
            if (state.occupiedField == false) {
            state.addSign(1, /* tu nie wiem jak to zrobić żeby program czekał aż
             wpiszę numer klawiaturą */ computer.yourTurn());
            } else {
                //komunikat żeby wybrać ponownie pole, bo wybrane jest zajęte iwtedy state.addSign();
            }
            state.getState();

        }

        scene.setOnKeyPressed(event -> {
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
        });
    }
}




