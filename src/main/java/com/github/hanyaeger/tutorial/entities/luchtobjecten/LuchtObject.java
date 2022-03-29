package com.github.hanyaeger.tutorial.entities.luchtobjecten;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.tutorial.entities.BulletCollider;
import com.github.hanyaeger.tutorial.entities.bommen.Bom;
import com.github.hanyaeger.tutorial.entities.bommen.Bullet;
import com.github.hanyaeger.tutorial.entities.bommen.KleineBom;
import com.github.hanyaeger.tutorial.scenes.GameLevel;
import javafx.scene.paint.Color;

import java.util.Random;

public class LuchtObject extends DynamicSpriteEntity implements UpdateExposer, Collided {
    private Bom bom;
    private GameLevel gameLevel;
    private double sceneWidth;

    private boolean randomXGemaakt = false;
    private boolean bomGeworpen = false;
    private double randomX = 0;

    protected LuchtObject(String resource, Bom bom, GameLevel gameLevel) {
        super(resource, new Coordinate2D(1, 200), new Size(200, 50));
        setMotion(2, Direction.RIGHT);
        this.bom = bom;
        this.gameLevel = gameLevel;
        this.sceneWidth = gameLevel.getWidth();
        explicitUpdate(5);
    }

    public void werpBom(Coordinate2D initialLocation){
        bom.setAnchorLocation(initialLocation);
        bom.setMotion(2,0);
        gameLevel.addBullet(bom);
        System.out.println(bom.getAnchorLocation());
    }

    @Override
    public void explicitUpdate(long l) {
        if(!randomXGemaakt) {
            randomX = new Random().nextInt((int) sceneWidth) + 1;
            randomXGemaakt = true;
        }
        if (getLocationInScene().getX() > randomX && !bomGeworpen) {
            werpBom(new Coordinate2D(randomX, 260));
            bomGeworpen = true;
        }
    }

    @Override
    public void onCollision(Collider collider) {
        remove();
        if(collider instanceof Bullet){
            ((Bullet) collider).explosion();
        }
    }
}
