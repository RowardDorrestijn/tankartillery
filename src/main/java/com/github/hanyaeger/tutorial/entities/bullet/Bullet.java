package com.github.hanyaeger.tutorial.entities.bullet;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.paint.Color;

public class Bullet extends DynamicCircleEntity implements Collided, SceneBorderCrossingWatcher, Newtonian {
    public Bullet(Coordinate2D initialLocation, double speed, double direction) {
        super(initialLocation);
        //System.out.println(initialLocation);
        setMotion(speed, direction + 90);
        setRadius(10);
        setFill(Color.BLACK);
        setStrokeColor(Color.RED);

        setGravityConstant(0.03);
        setFrictionConstant(0);
    }

    @Override
    public void onCollision(Collider collider) {
        //explosie geluid
        remove();
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        if(sceneBorder != sceneBorder.TOP) {
            remove();
        }
    }
}
