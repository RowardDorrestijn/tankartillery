package com.github.hanyaeger.tutorial.entities.luchtobjecten;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.entities.bommen.KleineBom;
import com.github.hanyaeger.tutorial.scenes.GameLevel;

public class BommenWerper extends Vliegtuig {

    /**
     * Ander soort vliegtuig dat een kleine bom mee draagt.
     *
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 28-03-2022
     */

    public BommenWerper(GameLevel gameLevel) {
        super("sprites/vliegtuig.png", new KleineBom(new Coordinate2D(1, 1)), gameLevel);
    }
}
