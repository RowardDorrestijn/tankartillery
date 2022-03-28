package com.github.hanyaeger.tutorial.entities.luchtobjecten;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.tutorial.entities.bommen.Bom;
import com.github.hanyaeger.tutorial.entities.bommen.KleineBom;
import com.github.hanyaeger.tutorial.scenes.GameLevel;

public class Vliegtuig extends LuchtObject{

    public Vliegtuig(GameLevel gameLevel) {
        super("sprites/vliegtuig.png", new KleineBom(new Coordinate2D(1, 1)), gameLevel);
    }
}
