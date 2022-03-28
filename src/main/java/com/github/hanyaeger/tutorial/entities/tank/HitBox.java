package com.github.hanyaeger.tutorial.entities.tank;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.tutorial.entities.BulletCollider;
import javafx.scene.paint.Color;

public class HitBox extends RectangleEntity implements Collided {
    private Tank tank;
    public HitBox(Coordinate2D initialLocation, int width, int height, Tank tank) {
        super(initialLocation);
        setWidth(width);
        setHeight(height);
        setFill(Color.TRANSPARENT);
        this.tank = tank;
    }

    @Override
    public void onCollision(Collider collider) {
        if(collider instanceof BulletCollider){
            ((BulletCollider) collider).explosion();
            tank.setHealth(((BulletCollider) collider).damage());
        }
    }

}
