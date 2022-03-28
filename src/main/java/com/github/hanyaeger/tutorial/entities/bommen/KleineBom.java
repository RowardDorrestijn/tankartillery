package com.github.hanyaeger.tutorial.entities.bommen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.entities.BulletCollider;
import javafx.scene.paint.Color;

public class KleineBom extends Bom implements Collider, Collided, SceneBorderCrossingWatcher, BulletCollider {

    public KleineBom(Coordinate2D initialLocation) {
        super(initialLocation, 2);
        setRadius(15);
        setFill(Color.GRAY);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }

}