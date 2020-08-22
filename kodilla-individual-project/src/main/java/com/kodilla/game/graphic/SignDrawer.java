package com.kodilla.game.graphic;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class SignDrawer {

    private GridPane grid = new GridPane();

    public GridPane getGrid() {
        return grid;
    }

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
}
