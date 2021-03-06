package com.github.hanyaeger.tutorial.entities.powerbar;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class PowerBarFill extends RectangleEntity {
    protected PowerBarFill(Coordinate2D initialLocation, int width) {
        super(initialLocation);
        setWidth(width);
        setHeight(24);
        setFill(Color.ORANGE);
    }

    /**
     * Zet de breedte van de powerbar
     *
     * @param width breedte
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 28-03-2022
     */

    public void setFillWidth(int width){
        setWidth(width);
    }

}
