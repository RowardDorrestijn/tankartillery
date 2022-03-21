package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.tutorial.entities.bullet.Bullet;
import com.github.hanyaeger.tutorial.entities.gebouw.Gebouw;
import com.github.hanyaeger.tutorial.entities.tank.Barrel;
import com.github.hanyaeger.tutorial.entities.tank.Tank;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import javafx.scene.input.MouseButton;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer, MouseButtonPressedListener {
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

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {

    }
}
