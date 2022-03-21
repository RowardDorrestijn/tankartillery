package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.entities.gebouw.Gebouw;
import com.github.hanyaeger.tutorial.entities.tank.Tank;
import com.github.hanyaeger.tutorial.entities.text.HealthText;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/achtergrond.png");
    }

    @Override
    public void setupEntities() {
        var gebouw = new Gebouw(
                new Coordinate2D(450, getHeight()-425)
        );
        addEntity(gebouw);

        var healthtext = new HealthText(
                new Coordinate2D(getWidth()-200, 100)
        );

        var tank = new Tank(
                new Coordinate2D(100, getHeight()-150), healthtext
        );
        addEntity(tank);
    }

    @Override
    public void setupEntitySpawners() {

    }
}
