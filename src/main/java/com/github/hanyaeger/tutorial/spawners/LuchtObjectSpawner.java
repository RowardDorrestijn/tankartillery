package com.github.hanyaeger.tutorial.spawners;

import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.entities.luchtobjecten.BommenWerper;
import com.github.hanyaeger.tutorial.entities.luchtobjecten.Vliegtuig;
import com.github.hanyaeger.tutorial.scenes.GameLevel;

import java.util.Random;

public class LuchtObjectSpawner extends EntitySpawner {

    private final double sceneWidth;
    private final double sceneHeight;
    private GameLevel gameLevel;

    public LuchtObjectSpawner(double sceneWidth, double sceneHeight, GameLevel gameLevel) {
        super(15000);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.gameLevel = gameLevel;
    }

    @Override
    protected void spawnEntities(){
        if(new Random().nextInt(10) < 8){
            spawn(new Vliegtuig(gameLevel));
        } else {
            spawn(new BommenWerper(gameLevel));
        }
    }
}
