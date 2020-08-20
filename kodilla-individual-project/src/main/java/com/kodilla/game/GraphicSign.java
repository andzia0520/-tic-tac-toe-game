package com.kodilla.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class GraphicSign extends ImageView {

    public GraphicSign(Image image) {
        super(image);
    }

    abstract public boolean isCross();
}
