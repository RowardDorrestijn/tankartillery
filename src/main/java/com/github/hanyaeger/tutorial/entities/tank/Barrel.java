package com.github.hanyaeger.tutorial.entities.tank;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.MouseMovedListener;
import javafx.scene.input.MouseButton;

public class Barrel extends DynamicSpriteEntity  implements MouseMovedListener {
    private double graden;
    private int length = 67;

    protected Barrel(Coordinate2D initialLocation) {
        super("sprites/barrel.png", initialLocation);
    }

    @Override
    public void onMouseMoved(Coordinate2D coordinate2D) {
        graden = angleTo(coordinate2D) - 90;
        if(graden < 90 && graden > 0) {
            setRotate(graden);
        }
        //System.out.println(getAnchorLocation());
    }
    public double getGraden(){
        return graden;
    }
    public int getLength(){
        return length;
    }
}
