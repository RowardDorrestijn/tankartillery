package com.github.hanyaeger.tutorial.entities.gebouw;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;


public class Gebouw extends DynamicCompositeEntity {


    public Gebouw(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    /**
     * Vierkante flat met een hitbox. Dient als obstakel.
     * Heeft twee hitboxen voor betere collision.
     *
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 21-03-2022
     */

    @Override
    protected void setupEntities() {
        var gebouwsprite = new GebouwSprite(
                new Coordinate2D(0, 0)
        );
        addEntity(gebouwsprite);

        var hitboxRechts = new HitBox(
                new Coordinate2D(130, 0), 160, 350
        );

        var hitboxLinks = new HitBox(
                new Coordinate2D(0, 20), 130, 330
        );
        addEntity(hitboxRechts);
        addEntity(hitboxLinks);


    }
}
