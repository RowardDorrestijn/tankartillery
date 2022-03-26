package com.github.hanyaeger.tutorial.entities.powerbar;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class PowerBarStroke extends RectangleEntity {

    protected PowerBarStroke(Coordinate2D initialLocation) {
        super(initialLocation);
        setWidth(100);
        setHeight(50);
        setStrokeColor(Color.BLACK);
    }

}
