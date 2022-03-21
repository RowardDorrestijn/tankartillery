package com.github.hanyaeger.tutorial.entities.bullet;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.entities.impl.DynamicEllipseEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class Bullet extends DynamicCircleEntity implements Collided, SceneBorderCrossingWatcher, Newtonian {
    protected Bullet(Coordinate2D initialLocation, int speed, Direction direction) {
        super(initialLocation);
        setMotion(speed, direction);
        setRadius(10);
        setFill(Color.BLACK);

        setGravityConstant(0.01);
        setFrictionConstant(0.04);
    }

    @Override
    public void onCollision(Collider collider) {
        //explosie geluid
        remove();
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }
}
