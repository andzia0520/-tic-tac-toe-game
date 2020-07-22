package com.kodilla.game;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Cross extends Sign {

    public Cross() {
        super(new Image ("file/cross.jpg" ));
    }

    @Override
    public boolean isCross() {
        return true;
    }
}
