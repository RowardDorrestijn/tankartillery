package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseMovedListener;
import com.github.hanyaeger.tutorial.entities.bullet.Bullet;
import com.github.hanyaeger.tutorial.entities.bullet.BulletSpawner;
import com.github.hanyaeger.tutorial.entities.gebouw.Gebouw;
import com.github.hanyaeger.tutorial.entities.spelers.Speler1;
import com.github.hanyaeger.tutorial.entities.spelers.Speler2;
import com.github.hanyaeger.tutorial.entities.tank.Tank;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import javafx.scene.input.MouseButton;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer, MouseButtonPressedListener, MouseMovedListener {
    private Tank speler1;
    private Tank speler2;
    private BulletSpawner bulletspawner = new BulletSpawner();
    private boolean aanDeBeurt = true; //True = speler1, false = speler2

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
        addEntity(healthtext);

        speler1 = new Speler1(
                new Coordinate2D(100, getHeight()-150), healthtext, this, "sprites/tankGroen1.png"
        );
        addEntity(speler1);

        speler2 = new Speler2(
                new Coordinate2D(getWidth()-246, getHeight()-150), healthtext, this, "sprites/tankGroen2.png"
        );
        addEntity(speler2);

    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(bulletspawner);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if(aanDeBeurt) {
            speler1.schiet(mouseButton, coordinate2D);
            aanDeBeurt = !aanDeBeurt;
        }else{
            speler2.schiet(mouseButton, coordinate2D);
            aanDeBeurt = !aanDeBeurt;
        }
    }

    public void addBullet(Bullet kogel){
        addEntity(kogel);
    }

    @Override
    public void onMouseMoved(Coordinate2D coordinate2D) {
        if(aanDeBeurt){
            speler1.draaiBarrel(coordinate2D);
        }else{
            speler2.draaiBarrel(coordinate2D);
        }
    }
}
