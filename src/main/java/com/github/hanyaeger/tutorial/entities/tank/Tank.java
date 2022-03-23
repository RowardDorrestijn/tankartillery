package com.github.hanyaeger.tutorial.entities.tank;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.tutorial.entities.bullet.Bullet;
import com.github.hanyaeger.tutorial.entities.bullet.BulletSpawner;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.scenes.GameLevel;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;


import java.util.Set;

import static java.lang.Math.floor;
import static java.lang.Math.round;

public abstract class Tank extends DynamicCompositeEntity implements Collided, KeyListener, SceneBorderTouchingWatcher, MouseButtonPressedListener {
    private HealthText healthText;
    private int health = 10;
    private Barrel barrel;
    private GameLevel gamelevel;
    private String tankKleur;

    public Tank(Coordinate2D initialLocation, HealthText healthText, GameLevel gamelevel, String tankKleur) {
        super(initialLocation);
        this.healthText = healthText;
        healthText.setHealthText(health);
        this.gamelevel = gamelevel;
        this.tankKleur = tankKleur;
    }

    @Override
    protected void setupEntities() {
        var tanksprite = new TankSprite(
                tankKleur, new Coordinate2D(0, 0)
        );

        barrel = new Barrel(
                "sprites/barrel.png", new Coordinate2D(20, 25)
        );
        addEntity(tanksprite);
        addEntity(barrel);
    }

    @Override
    public void onCollision(Collider collider) {

    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {

    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {

    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
    }

    public void schiet(MouseButton mouseButton, Coordinate2D coordinate2D){
        double tankCoordX = this.getLocationInScene().getX() + 100;
        double tankCoordY = this.getLocationInScene().getY() + 50;

        var kogel = new Bullet(
                new Coordinate2D(tankCoordX , tankCoordY), getSpeed(coordinate2D), barrel.getGraden()
        );
        gamelevel.addBullet(kogel);
    }

    public void draaiBarrel(double graden, Coordinate2D coordinate2D){
    }

    private double getSpeed(Coordinate2D coordinate2D){
        double afstand = distanceTo(coordinate2D);
        return afstand/100 + 2;
    }

    public double getGraden(){
        return barrel.getGraden();
    }

    public GameLevel getGamelevel(){
        return gamelevel;
    }

    public Barrel getBarrel(){
        return barrel;
    }

    public abstract void draaiBarrel(Coordinate2D coordinate2D);
}
