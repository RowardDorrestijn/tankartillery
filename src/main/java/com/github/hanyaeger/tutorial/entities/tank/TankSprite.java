package com.github.hanyaeger.tutorial.entities.tank;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class TankSprite extends DynamicSpriteEntity {

    protected TankSprite(Coordinate2D initialLocation) {
        super("sprites/tankGroen1.png", initialLocation, new Size(150), 1, 1);
    }
}
