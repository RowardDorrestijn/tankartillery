package com.github.hanyaeger.tutorial.entities.gebouw;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class HitBox extends RectangleEntity implements Collider {
    public HitBox(Coordinate2D initialLocation, int width, int height) {
        super(initialLocation);
        setWidth(width);
        setHeight(height);
        setFill(Color.TRANSPARENT);
    }

}
