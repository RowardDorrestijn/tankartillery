package com.github.hanyaeger.tutorial.entities.luchtobjecten;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.tutorial.entities.bommen.Bom;
import com.github.hanyaeger.tutorial.entities.bommen.Bullet;
import com.github.hanyaeger.tutorial.scenes.GameLevel;

import java.util.Random;

public class Vliegtuig extends DynamicSpriteEntity implements UpdateExposer, Collided {
    private Bom bom;
    private GameLevel gameLevel;
    private double sceneWidth;

    private boolean randomXGemaakt = false;
    private boolean bomGeworpen = false;
    private double randomX = 0;

    protected Vliegtuig(String resource, Bom bom, GameLevel gameLevel) {
        super(resource, new Coordinate2D(1, 200), new Size(200, 50));
        setMotion(2, Direction.RIGHT);
        this.bom = bom;
        this.gameLevel = gameLevel;
        this.sceneWidth = gameLevel.getWidth();
        explicitUpdate(5);
    }

    /**
     * Gooit de bom die is meegegeven in het spel.
     *
     * @param initialLocation locatie waar bom wordt gegooid
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 28-03-2022
     */

    public void werpBom(Coordinate2D initialLocation){
        bom.setAnchorLocation(initialLocation);
        bom.setMotion(2,0);
        gameLevel.addBom(bom);
    }


    /**
     * Updater die checkt of dat het vliegtuig al op locatie is om de bom te gooien.
     *
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 28-03-2022
     */
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

    /**
     * Verdwijnt zodra het geraakt wordt door een bullet.
     *
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 28-03-2022
     */

    @Override
    public void onCollision(Collider collider) {
        remove();
        if(collider instanceof Bullet){
            ((Bullet) collider).explosion();
        }
    }
}
