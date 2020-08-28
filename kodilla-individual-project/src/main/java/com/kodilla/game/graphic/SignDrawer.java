package com.kodilla.game.graphic;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.Optional;

public class SignDrawer {

    private final GridPane grid = new GridPane();

    public GridPane getGrid() {
        return grid;
    }

    public SignDrawer() {

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(new Image("file/sceneIntro.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        grid.getColumnConstraints().add(new ColumnConstraints(160));
        grid.getColumnConstraints().add(new ColumnConstraints(160));
        grid.getColumnConstraints().add(new ColumnConstraints(140));
        grid.getColumnConstraints().add(new ColumnConstraints(140));

        grid.getRowConstraints().add(new RowConstraints(90));
        grid.getRowConstraints().add(new RowConstraints(95));
        grid.getRowConstraints().add(new RowConstraints(190));

        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(0, 0, 0, 0));
        grid.setHgap(5);
        grid.setVgap(10);
        grid.setBackground(background);
    }

    public void addSign(int position, GraphicSign graphicSign) {
        switch (position) {
            case 1:
                grid.add(graphicSign, 2, 1, 1, 1);
                break;
            case 2:
                grid.add(graphicSign, 3, 1, 1, 1);
                break;
            case 3:
                grid.add(graphicSign, 4, 1, 1, 1);
                break;
            case 4:
                grid.add(graphicSign, 2, 2, 1, 1);
                break;
            case 5:
                grid.add(graphicSign, 3, 2, 1, 1);
                break;
            case 6:
                grid.add(graphicSign, 4, 2, 1, 1);
                break;
            case 7:
                grid.add(graphicSign, 2, 3, 1, 1);
                break;
            case 8:
                grid.add(graphicSign, 3, 3, 1, 1);
                break;
            case 9:
                grid.add(graphicSign, 4, 3, 1, 1);
                break;
        }
    }

    public void showPlayerWon() {
        Alert playerWon = new Alert(Alert.AlertType.INFORMATION);
        playerWon.setTitle("Good news");
        playerWon.setHeaderText(null);
        playerWon.setContentText("\n      Congratulations, you won !!!");

        playerWon.showAndWait();
    }

    public void showComputerWon() {
        Alert computerWon = new Alert(Alert.AlertType.INFORMATION);
        computerWon.setTitle("Uuuuuups");
        computerWon.setHeaderText(null);
        computerWon.setContentText("\n      Computer won :(");

        computerWon.showAndWait();
    }

    public void showDraw() {
        Alert draw = new Alert(Alert.AlertType.INFORMATION);
        draw.setTitle("Good news");
        draw.setHeaderText(null);
        draw.setContentText("\n      Draw !!!");

        draw.showAndWait();
    }

    public void showMessage() {
        Alert illegalMovement = new Alert(Alert.AlertType.WARNING);
        illegalMovement.setTitle("Illegal game movement");
        illegalMovement.setHeaderText(null);
        illegalMovement.setContentText("Please choose only empty fields (use keys 1 - 9)");

        illegalMovement.showAndWait();
    }

    public void clearBoard() {
        grid.getChildren().clear();
    }

    public void playAgainOrClose() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Game over");
        alert.setHeaderText(null);
        alert.setContentText("Do you want to play again?");

        ButtonType buttonTypeYES = new ButtonType("YES");
        ButtonType buttonTypeNo = new ButtonType("NO");

        alert.getButtonTypes().setAll(buttonTypeYES, buttonTypeNo);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeYES) {
           clearBoard();
        } else {
            Platform.exit();
        }
    }
}
