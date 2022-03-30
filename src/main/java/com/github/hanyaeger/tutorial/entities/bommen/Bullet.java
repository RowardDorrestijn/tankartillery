package com.github.hanyaeger.tutorial.entities.bommen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.entities.BulletCollider;
import javafx.scene.paint.Color;

public class Bullet extends Bom implements SceneBorderCrossingWatcher, Newtonian {
    public Bullet(Coordinate2D initialLocation, double speed, double direction) {
        super(initialLocation, 1);
        setMotion(speed, direction + 90);
        setRadius(10);
        setFill(Color.BLACK);

        setGravityConstant(0.03);
        setFrictionConstant(0);
    }

    /**
     * Bullet wordt verwijderd alleen verwijderd als het niet aan de bovenkant de scene uitvliegt.
     * Moet weer terug kunnen vallen als het aan de bovenkant eruitvliegt.
     *
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 24-03-2022
     */

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        if(sceneBorder != sceneBorder.TOP) {
            remove();
        }
    }
}
