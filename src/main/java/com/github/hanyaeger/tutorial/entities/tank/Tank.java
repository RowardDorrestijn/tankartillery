package com.github.hanyaeger.tutorial.entities.tank;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.entities.bommen.Bullet;
import com.github.hanyaeger.tutorial.entities.powerbar.PowerBar;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.scenes.GameLevel;
import javafx.scene.input.MouseButton;

import static java.lang.Math.round;

public abstract class Tank extends DynamicCompositeEntity {
    private HealthText healthText;
    private int health = 10;
    protected Barrel barrel;
    private GameLevel gamelevel;
    private String tankKleur;
    protected PowerBar powerBar;


    public Tank(Coordinate2D initialLocation, HealthText healthText, GameLevel gamelevel, String tankKleur, PowerBar powerBar) {
        super(initialLocation);
        this.healthText = healthText;
        healthText.setHealthText(health);
        this.gamelevel = gamelevel;
        this.tankKleur = tankKleur;
        this.powerBar = powerBar;
    }

    /**
     * Zet alle atributen van de tank bij elkaar. Heeft een aparte barrel, want die moet apart bewegen.
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 21-03-2022
     */

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
        addEntity(hitbox);
        addEntity(tanksprite);
        addEntity(barrel);
    }


    /**
     * Maakt een kogel aan op basis van waar de muis heeft geklikt.
     * Beginlocatie is wat hoger dan de tank is, zodat er geen collision optreedt.
     *
     * @param mouseButton de muis zelf
     * @param mouseCoordinate locatie van de muis.
     * @param beginCoordinate locatie vanaf waar de kogel wordt geschoten (speler1 of speler2)
     *
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 22-03-2022
     */
    public void schiet(MouseButton mouseButton, Coordinate2D mouseCoordinate, Coordinate2D beginCoordinate){
        double tankCoordX = this.getLocationInScene().getX() + beginCoordinate.getX();
        double tankCoordY = this.getLocationInScene().getY() + beginCoordinate.getY();

        var kogel = new Bullet(
                new Coordinate2D(tankCoordX , tankCoordY), getSpeed(mouseCoordinate), barrel.getGraden()
        );
        gamelevel.addBom(kogel);
    }

    /**
     * Berekent de snelheid op basis van de afstand tussen de tank en de muis.
     *
     * @param coordinate2D locatie van de muis
     * @return snelheid
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 24-03-2022
     */

    public double getSpeed(Coordinate2D coordinate2D){
        double afstand = distanceTo(coordinate2D);
        return afstand/100 + 2;
    }

    /**
     * Abstracte methode voor het draaien van de barrel. Is voor elke tank verschillend.
     *
     * @param coordinate2D locatie van de muis
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 24-03-2022
     */
    public abstract void draaiBarrel(Coordinate2D coordinate2D);


    /**
     * Zet het aantal levens van de tank.
     * Bij 0 of minder is de speler dood.
     *
     * @param health aantal damage
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 23-03-2022
     */
    public void setHealth(int health){
        this.health -= health;
        this.healthText.setHealthText(this.health);
        if(this.health <= 0){
            sterf();
        }
    }


    /**
     * Geeft het aantal levens van de tank
     *
     * @return health
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 23-03-2022
     */
    public int getHealth(){
        return health;
    }


    /**
     * Verwijdert de speler, en laat een grote explosie horen.
     *
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 28-03-2022
     */
    public void sterf(){
        this.remove();
        var explosie = new SoundClip("audio/test.mp3");
        explosie.play();
    }
}
