package com.github.hanyaeger.tutorial.entities.tank;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.tutorial.entities.bullet.Bullet;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;


import java.util.Set;

public class Tank extends DynamicCompositeEntity implements Collided, KeyListener, SceneBorderTouchingWatcher, MouseButtonPressedListener {
    private HealthText healthText;
    private int health = 10;
    private Barrel barrel;

    public Tank(Coordinate2D initialLocation, HealthText healthText) {
        super(initialLocation);
        this.healthText = healthText;
        healthText.setHealthText(health);
    }

    @Override
    protected void setupEntities() {
        var tanksprite = new TankSprite(
                new Coordinate2D(0, 0)
        );
        addEntity(tanksprite);
        barrel = new Barrel(
                new Coordinate2D(20, 25)
        );
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
        System.out.println(coordinate2D);
        double xCoord = Math.sin(barrel.getGraden()) * barrel.getLength();
        double yCoord = Math.cos(barrel.getGraden()) * barrel.getLength();
        System.out.println(xCoord + " " + yCoord);
        addEntity(new Bullet(new Coordinate2D(20, 50), 2, 90d));
    }

}
