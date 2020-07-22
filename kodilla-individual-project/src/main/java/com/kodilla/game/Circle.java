package com.kodilla.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Circle extends Sign {

    public Circle() {
        super(new Image ("file/circle.png" ));
    }

    @Override
    public boolean isCross() {
        return false;
    }
}
