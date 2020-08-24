package com.kodilla.game.graphic;

import com.kodilla.game.logic.GameResult;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import static com.kodilla.game.logic.GameResult.PLAYER_WON;

public class SignDrawer {

    private GridPane grid = new GridPane();

    public GridPane getGrid() {
        return grid;
    }

    public SignDrawer() {

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(new Image("file/scene 2.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        grid.getColumnConstraints().add(new ColumnConstraints(100));
        grid.getColumnConstraints().add(new ColumnConstraints(110));
        grid.getColumnConstraints().add(new ColumnConstraints(120));

        grid.getRowConstraints().add(new RowConstraints(53));
        grid.getRowConstraints().add(new RowConstraints(100));
        grid.getRowConstraints().add(new RowConstraints(140));

        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(0, 0, 0, 0));
        grid.setHgap(5);
        grid.setVgap(10);
        grid.setBackground(background);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Welcome to the Game");
        alert.setHeaderText(null);
        alert.setContentText("Dear Player, \n" +
                "Lets start to play the TicTacToe game. You start as first, your moves are symbolized by an \"X\", and computers moves by \"O\".\n" +
                "The game is operated with keys 1 - 9. Press the number of the field on which you want to place your symbol.\n" +
                "Good luck !!!\n");

        alert.showAndWait();
    }

    public void addSign(int position, GraphicSign graphicSign) {
        switch (position) {
            case 1:
                grid.add(graphicSign, 1, 1, 1, 1);
                break;
            case 2:
                grid.add(graphicSign, 2, 1, 1, 1);
                break;
            case 3:
                grid.add(graphicSign, 3, 1, 1, 1);
                break;
            case 4:
                grid.add(graphicSign, 1, 2, 1, 1);
                break;
            case 5:
                grid.add(graphicSign, 2, 2, 1, 1);
                break;
            case 6:
                grid.add(graphicSign, 3, 2, 1, 1);
                break;
            case 7:
                grid.add(graphicSign, 1, 3, 1, 1);
                break;
            case 8:
                grid.add(graphicSign, 2, 3, 1, 1);
                break;
            case 9:
                grid.add(graphicSign, 3, 3, 1, 1);
                break;
        }
    }

    public void showGameResult(GameResult gameResult) {
        if(gameResult == GameResult.PLAYER_WON) {
            Alert playerWon = new Alert(Alert.AlertType.INFORMATION);
            playerWon.setTitle("Good news");
            playerWon.setHeaderText(null);
            playerWon.setContentText("\n      Congratulations, you won !!!");

            playerWon.showAndWait();

        } else if(gameResult == GameResult.COMPUTER_WON)  {
            Alert computerWon = new Alert(Alert.AlertType.INFORMATION);
            computerWon.setTitle("Uuuuuups");
            computerWon.setHeaderText(null);
            computerWon.setContentText("\n      Computer won :(");

            computerWon.showAndWait();

        } else {
            Alert draw = new Alert(Alert.AlertType.INFORMATION);
            draw.setTitle("Good news");
            draw.setHeaderText(null);
            draw.setContentText("\n      Draw !!!");

            draw.showAndWait();
        }
    }

    public void showMessage(){
        Alert illegalMovement = new Alert(Alert.AlertType.WARNING);
        illegalMovement.setTitle("Illegal game movement");
        illegalMovement.setHeaderText(null);
        illegalMovement.setContentText("Please choose only empty fields (1 - 9)");

        illegalMovement.showAndWait();
    }
}
