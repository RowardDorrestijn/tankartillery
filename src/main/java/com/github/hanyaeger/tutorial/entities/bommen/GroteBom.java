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

public class GroteBom extends Bom implements Collider, Collided, SceneBorderCrossingWatcher, BulletCollider {

    public GroteBom(Coordinate2D initialLocation) {
        super(initialLocation, 5);
        setRadius(20);
        setFill(Color.DARKGREEN);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }

}