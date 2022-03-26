package com.github.hanyaeger.tutorial.entities.tank;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.tutorial.entities.bullet.Bullet;
import com.github.hanyaeger.tutorial.entities.powerbar.PowerBar;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.entities.text.NameText;
import com.github.hanyaeger.tutorial.scenes.GameLevel;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import java.util.concurrent.TimeUnit;

import java.util.Set;
import java.util.jar.Attributes;

import static java.lang.Math.pow;
import static java.lang.Math.round;

public abstract class Tank extends DynamicCompositeEntity implements KeyListener, SceneBorderTouchingWatcher, MouseButtonPressedListener {
    private HealthText healthText;
    private int health = 10;
    private Barrel barrel;
    private GameLevel gamelevel;
    private String tankKleur;
    private PowerBar powerBar;


    public Tank(Coordinate2D initialLocation, HealthText healthText, GameLevel gamelevel, String tankKleur, PowerBar powerBar) {
        super(initialLocation);
        this.healthText = healthText;
        healthText.setHealthText(health);
        this.gamelevel = gamelevel;
        this.tankKleur = tankKleur;
        this.powerBar = powerBar;
    }

    @Override
    protected void setupEntities() {
        var tanksprite = new TankSprite(
                tankKleur, new Coordinate2D(0, 0)
        );

        barrel = new Barrel(
                "sprites/barrel.png", new Coordinate2D(20, 25)
        );
        var hitbox = new HitBox(
                new Coordinate2D(0, 25), 150, 55, this
        );
        hitbox.setStrokeColor(Color.RED);
        addEntity(hitbox);
        addEntity(tanksprite);
        addEntity(barrel);
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

    public void schiet(MouseButton mouseButton, Coordinate2D mouseCoordinate, Coordinate2D beginCoordinate){
        double tankCoordX = this.getLocationInScene().getX() + beginCoordinate.getX();
        double tankCoordY = this.getLocationInScene().getY() + beginCoordinate.getY();

        var kogel = new Bullet(
                new Coordinate2D(tankCoordX , tankCoordY), getSpeed(mouseCoordinate), barrel.getGraden()
        );
        gamelevel.addBullet(kogel);
    }

    private double getSpeed(Coordinate2D coordinate2D){
        double afstand = distanceTo(coordinate2D);
        return afstand/100 + 2;
    }

    public Barrel getBarrel(){
        return barrel;
    }

    public PowerBar getPowerBar(){return powerBar;}

    public abstract void draaiBarrel(Coordinate2D coordinate2D);

    public void setHealthText(){
        this.health--;
        this.healthText.setHealthText(this.health);
        if(this.health == 0){
            this.sterf();
        }
    }

    public void sterf(){
        this.remove();
        var explosie = new SoundClip("audio/test.mp3");
        explosie.play();
        gamelevel.getTankArtillery().setActiveScene(1);
    }
}
