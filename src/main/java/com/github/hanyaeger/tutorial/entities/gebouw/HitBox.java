package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class HitBox extends RectangleEntity implements Collider {
    public HitBox(Coordinate2D initialLocation) {
        super(initialLocation);
        setWidth(300);
        setHeight(350);
        setFill(Color.TRANSPARENT);
    }

}
