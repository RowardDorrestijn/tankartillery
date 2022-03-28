package com.github.hanyaeger.tutorial.entities.bommen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.entities.BulletCollider;
import javafx.scene.paint.Color;

public class Bom extends DynamicCircleEntity implements BulletCollider, Collider, Collided {
    private int damage;

    protected Bom(Coordinate2D initialLocation, int damage) {
        super(initialLocation);
        this.damage = damage;
    }

    @Override
    public void explosion() {
        remove();
        var explosie = new SoundClip("audio/explosieGeluid.mp3");
        explosie.play();
    }

    @Override
    public int damage() {
        return damage;
    }

    @Override
    public void onCollision(Collider collider) {
        explosion();
    }
}
