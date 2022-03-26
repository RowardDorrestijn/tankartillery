package com.github.hanyaeger.tutorial.entities.powerbar;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class PowerBarFill extends RectangleEntity {

    protected PowerBarFill(Coordinate2D initialLocation, int width) {
        super(initialLocation);
        setWidth(width);
        setHeight(50);
        setStrokeColor(Color.ORANGE);
    }

}
