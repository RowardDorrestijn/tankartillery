package com.github.hanyaeger.tutorial.entities.tank;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.MouseMovedListener;
import javafx.scene.input.MouseButton;

public class Barrel extends DynamicSpriteEntity{
    private double graden;

    public Barrel(String barrelSprite, Coordinate2D initialLocation) {
        super(barrelSprite, initialLocation);
    }

    public void setGraden(double graden){
        this.graden = graden;
    }
    public double getGraden(){
        return graden;
    }
}
