package com.kodilla.game;

import javafx.scene.image.Image;

public class Cross extends GraphicSign {

    public Cross() {
        super(new Image("file/cross.jpg"));
    }

    @Override
    public boolean isCross() {
        return true;
    }
}
