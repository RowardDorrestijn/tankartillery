package com.github.hanyaeger.tutorial.entities.luchtobjecten;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.entities.bommen.GroteBom;
import com.github.hanyaeger.tutorial.scenes.GameLevel;

public class NucleaireBommenWerper extends Vliegtuig {

    /**
     * Ander soort vliegtuig dat een grote bom mee draagt.
     *
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 28-03-2022
     */

    public NucleaireBommenWerper(GameLevel gameLevel) {
        super("sprites/bommenwerper.png", new GroteBom(new Coordinate2D(1, 1)), gameLevel);
    }

}
