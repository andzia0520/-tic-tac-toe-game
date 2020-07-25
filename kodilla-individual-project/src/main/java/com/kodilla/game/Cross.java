package com.kodilla.game;

import javafx.scene.image.Image;

public class Cross extends Sign {

    public Cross() {
        super(new Image("file/cross.jpg"));
    }

    @Override
    public boolean isCross() {
        return true;
    }
}
