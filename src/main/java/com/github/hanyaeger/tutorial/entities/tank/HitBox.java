package com.github.hanyaeger.tutorial.entities.tank;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.tutorial.entities.bullet.Bullet;
import javafx.scene.paint.Color;

public class HitBox extends RectangleEntity implements Collided {
    public HitBox(Coordinate2D initialLocation, int width, int height) {
        super(initialLocation);
        setWidth(width);
        setHeight(height);
        setFill(Color.TRANSPARENT);
    }

    @Override
    public void onCollision(Collider collider) {
        System.out.println("test");
        if(collider instanceof Bullet){
            Bullet kogel = (Bullet) collider;
            kogel.remove();
        }
    }

}
