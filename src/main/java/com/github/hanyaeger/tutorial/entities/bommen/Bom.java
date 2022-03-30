package com.github.hanyaeger.tutorial.entities.bommen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.entities.BulletCollider;



public class Bom extends DynamicCircleEntity implements BulletCollider, Collider, Collided {
    private int damage;

    protected Bom(Coordinate2D initialLocation, int damage) {
        super(initialLocation);
        this.damage = damage;
    }

    /**
     * Maakt gebruik van de interface BulletCollider.
     * Kogel wordt verwijderd bij collision. Maakt een explosie geluid.
     *
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 28-03-2022
     */

    @Override
    public void explosion() {
        remove();
        var explosie = new SoundClip("audio/explosieGeluid.mp3");
        explosie.play();
    }

    /**
     * Geeft de damage terug.
     *
     * @return damage
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 28-03-2022
     */

    @Override
    public int damage() {
        return damage;
    }

    /**
     * Zodra het iets raakt moet het exploderen.
     *
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 28-03-2022
     */


    @Override
    public void onCollision(Collider collider) {
        explosion();
    }
}
