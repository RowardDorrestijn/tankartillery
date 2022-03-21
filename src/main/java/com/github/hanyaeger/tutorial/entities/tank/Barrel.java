package com.github.hanyaeger.tutorial.entities.tank;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.MouseMovedListener;
import javafx.scene.input.MouseButton;

public class Barrel extends DynamicSpriteEntity  implements MouseMovedListener {
    protected Barrel(Coordinate2D initialLocation) {
        super("sprites/barrel.png", initialLocation);

    }

    @Override
    public void onMouseMoved(Coordinate2D coordinate2D) {
        double graden = angleTo(coordinate2D);
        //setRotate(graden);
        setRotate(90);
        System.out.println(graden);
    }
}
