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


    /**
     * Als de tank wordt geraakt in de hitbox, krijgt de tank damage.
     * Door polymorfie hoeft alleen maar worden gekeken of dat de collider de interface BulletCollider implementeert.
     *
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 23-03-2022
     */

    @Override
    public void onCollision(Collider collider) {
        if(collider instanceof BulletCollider){
            ((BulletCollider) collider).explosion();
            tank.setHealth(((BulletCollider) collider).damage());
        }
    }

}
