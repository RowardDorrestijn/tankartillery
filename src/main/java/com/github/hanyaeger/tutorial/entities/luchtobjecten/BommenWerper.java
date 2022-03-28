package com.github.hanyaeger.tutorial.entities.luchtobjecten;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.tutorial.entities.bommen.Bom;
import com.github.hanyaeger.tutorial.entities.bommen.GroteBom;
import com.github.hanyaeger.tutorial.entities.bommen.KleineBom;
import com.github.hanyaeger.tutorial.scenes.GameLevel;

public class BommenWerper extends LuchtObject{

    public BommenWerper(GameLevel gameLevel) {
        super("sprites/bommenwerper.png", new GroteBom(new Coordinate2D(1, 1)), gameLevel);
    }

}
