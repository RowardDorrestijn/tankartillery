package com.github.hanyaeger.tutorial.entities.tank;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Barrel extends DynamicSpriteEntity{
    private double graden;

    public Barrel(String barrelSprite, Coordinate2D initialLocation) {
        super(barrelSprite, initialLocation);
    }

    /**
     * Setter en getter voor de hoek die de barrel maakt.
     *
     * @param graden aantal graden
     * @return aantal graden
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 24-03-2022
     */

    public void setGraden(double graden){
        this.graden = graden;
    }

    public double getGraden(){
        return graden;
    }
}
