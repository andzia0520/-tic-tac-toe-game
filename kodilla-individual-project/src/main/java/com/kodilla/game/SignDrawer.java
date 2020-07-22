package com.kodilla.game;

import javafx.geometry.Insets;
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

        grid.setPadding(new Insets(5, 5, 5, 0));
        grid.setHgap(20);
        grid.setVgap(17);
        grid.setBackground(background);
    }


    public void addSign(int position, Sign sign) {
        switch(position) {
            case 1:
                grid.add(sign,5,4,1,1);
                break;
            case 2:
                grid.add(sign,7,4,1,1);
                break;
            case 3:
                grid.add(sign,9,4,1,1);
                break;

        }
    }


//
//        grid.add(pos2,7,4,1,1);
//        grid.add(pos3,9,4,1,1);
//        grid.add(pos4,5,7,1,1);
//        grid.add(pos5,7,7,1,1);
//        grid.add(pos6,9,7,1,1);
//        grid.add(pos7,5,10,1,1);
//        grid.add(pos8,7,10,1,1);
//        grid.add(pos9,9,10,1,1);
}
