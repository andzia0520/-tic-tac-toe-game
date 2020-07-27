package com.kodilla.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import static com.kodilla.game.GameResult.PLAYER_WON;

public class SignDrawer {

    private GridPane grid = new GridPane();

    public GridPane getGrid() {
        return grid;
    }
    private final Image youWon = new Image("file/youWon.png");
    private final Image computerWon = new Image("file/computerWon.png");
    private final Image draw = new Image("file/Draw.png");
    private final Image noResult = new Image("file/noResult.png");


    public SignDrawer() {

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(new Image("file/scene.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
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
    }

    public void addSign(int position, Sign sign) {
        switch (position) {
            case 1:
                grid.add(sign, 1, 1, 1, 1);
                break;
            case 2:
                grid.add(sign, 2, 1, 1, 1);
                break;
            case 3:
                grid.add(sign, 3, 1, 1, 1);
                break;
            case 4:
                grid.add(sign, 1, 2, 1, 1);
                break;
            case 5:
                grid.add(sign, 2, 2, 1, 1);
                break;
            case 6:
                grid.add(sign, 3, 2, 1, 1);
                break;
            case 7:
                grid.add(sign, 1, 3, 1, 1);
                break;
            case 8:
                grid.add(sign, 2, 3, 1, 1);
                break;
            case 9:
                grid.add(sign, 3, 3, 1, 1);
                break;
        }
    }

    /*public void getGameResult(GameResult gameResult, int position) {
        switch(gameResult, position) {
        case PLAYER_WON):
            grid.add(gameResult, 1, 1 ,2, 1);
        } else if (GameResult.COMPUTER_WON){
            grid.add(computerWon, 1, 1 ,2, 1);
        } else if (GameResult.DRAW) {
            grid.add(draw, 1, 1 ,2, 1);
        } else {
            grid.add(noResult, 1, 1 ,2, 1);
        }

    }*/
}
