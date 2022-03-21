package com.github.hanyaeger.tutorial.entities.gebouw;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class GebouwSprite extends DynamicSpriteEntity {

    protected GebouwSprite(Coordinate2D initialLocation) {
        super("sprites/flatgebouw.png", initialLocation, new Size(300, 900));
    }
}
