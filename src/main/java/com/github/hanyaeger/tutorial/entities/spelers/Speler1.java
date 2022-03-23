package com.github.hanyaeger.tutorial.entities.spelers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.entities.tank.Barrel;
import com.github.hanyaeger.tutorial.entities.tank.Tank;
import com.github.hanyaeger.tutorial.entities.tank.TankSprite;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.scenes.GameLevel;
import javafx.scene.input.MouseButton;

public class Speler1 extends Tank {
    private String tankKleur;
    private Barrel barrel;

    public Speler1(Coordinate2D initialLocation, HealthText healthText, GameLevel gamelevel, String tankKleur) {
        super(initialLocation, healthText, gamelevel, tankKleur);
    }


    @Override
    public void schiet(MouseButton mouseButton, Coordinate2D coordinate2D) {
        super.schiet(mouseButton, coordinate2D);
    }

    @Override
    public void draaiBarrel(Coordinate2D coordinate2D) {
        Barrel barrel = getBarrel();
        double graden = angleTo(coordinate2D) - 90;
        System.out.println(graden);
        if (graden < 90 && graden >= 0) {
            barrel.setRotate(graden);
            barrel.setGraden(graden);
        }
    }
}
