package com.github.hanyaeger.tutorial.entities.gebouw;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.tutorial.TankArtillery;
import com.github.hanyaeger.tutorial.entities.HitBox;
import javafx.scene.paint.Color;

public class Gebouw extends DynamicCompositeEntity {


    public Gebouw(Coordinate2D initialLocation) {
        super(initialLocation);
    }

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
        hitboxRechts.setStrokeColor(Color.RED);
        hitboxLinks.setStrokeColor(Color.RED);
        addEntity(hitboxRechts);
        addEntity(hitboxLinks);


    }
}
