package com.github.hanyaeger.tutorial.spawners;

import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.entities.luchtobjecten.NucleaireBommenWerper;
import com.github.hanyaeger.tutorial.entities.luchtobjecten.BommenWerper;
import com.github.hanyaeger.tutorial.scenes.GameLevel;

import java.util.Random;

public class VliegtuigSpawner extends EntitySpawner {


    private GameLevel gameLevel;

    public VliegtuigSpawner(GameLevel gameLevel) {
        super(15000);
        this.gameLevel = gameLevel;
    }

    /**
     * Heeft een willekeurige kans of dat een grote of kleine bommenwerper wordt gespawnd.
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 21-03-2022
     */
    @Override
    protected void spawnEntities(){
        if(new Random().nextInt(10) < 8){
            spawn(new BommenWerper(gameLevel));
        } else {
            spawn(new NucleaireBommenWerper(gameLevel));
        }
    }
}
