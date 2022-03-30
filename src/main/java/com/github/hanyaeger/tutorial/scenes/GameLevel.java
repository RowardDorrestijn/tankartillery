package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseMovedListener;
import com.github.hanyaeger.tutorial.TankArtillery;
import com.github.hanyaeger.tutorial.entities.bommen.Bom;
import com.github.hanyaeger.tutorial.entities.gebouw.Gebouw;
import com.github.hanyaeger.tutorial.entities.powerbar.PowerBar;
import com.github.hanyaeger.tutorial.entities.spelers.Speler1;
import com.github.hanyaeger.tutorial.entities.spelers.Speler2;
import com.github.hanyaeger.tutorial.entities.tank.Tank;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.entities.text.NameText;
import com.github.hanyaeger.tutorial.spawners.VliegtuigSpawner;
import javafx.scene.input.MouseButton;

public class GameLevel extends DynamicScene implements MouseButtonPressedListener, MouseMovedListener, EntitySpawnerContainer, UpdateExposer {
    private Tank speler1;
    private Tank speler2;
    private boolean aanDeBeurt = true; //True = speler1, false = speler2

    private TankArtillery tankArtillery;

    public GameLevel(TankArtillery tankArtillery){
        this.tankArtillery = tankArtillery;
    }

    /**
     * Zet het spelscherm op. Er worden 2 tanks neergezet, en een gebouw.
     * Ook is er een powerbar en heeft elke speler een healthtext.
     * De vliegtuigSpawner wordt toegevoegd in setupEntitySpawners().
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 21-03-2022
     */

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/achtergrond.png");
    }

    @Override
    public void setupEntities() {
        var gebouw = new Gebouw(
                new Coordinate2D(450, getHeight()-425)
        );

        var healthtextSpeler1 = new HealthText(
                new Coordinate2D(100, 50)
        );

        var healthtextSpeler2 = new HealthText(
                new Coordinate2D(getWidth()-200, 50)
        );

        var nameTextSpeler1 = new NameText(
                new Coordinate2D(100, 0)
        );
        nameTextSpeler1.setNameText("Speler 1");

        var nameTextSpeler2 = new NameText(
                new Coordinate2D(getWidth()-200, 0)
        );
        nameTextSpeler2.setNameText("Speler 2");

        var powerBarSpeler1 = new PowerBar(
                new Coordinate2D(300, 50)
        );

        var powerBarSpeler2 = new PowerBar(
                new Coordinate2D(getWidth()-400, 50)
        );

        speler1 = new Speler1(
                new Coordinate2D(100, getHeight()-150), healthtextSpeler1, this, tankArtillery.getKleurSpeler1(), powerBarSpeler1
        );

        speler2 = new Speler2(
                new Coordinate2D(getWidth()-246, getHeight()-150), healthtextSpeler2, this, tankArtillery.getKleurSpeler2(), powerBarSpeler2
        );

        addEntity(gebouw);
        addEntity(healthtextSpeler1);
        addEntity(healthtextSpeler2);
        addEntity(nameTextSpeler1);
        addEntity(nameTextSpeler2);
        addEntity(powerBarSpeler1);
        addEntity(powerBarSpeler2);
        addEntity(speler1);
        addEntity(speler2);

        explicitUpdate(500);

    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new VliegtuigSpawner(this));
    }


    /**
     * Als er in het spel geklikt wordt, dan wordt er een kogel geschoten.
     * Hierna wordt de boolean aanDeBeurt geswitcht. Als aanDeBeurt true is, dan is speler1 aan de beurt en andersom.
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 23-03-2022
     */

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if(aanDeBeurt) {
            speler1.schiet(mouseButton, coordinate2D, new Coordinate2D(100, -30));
            aanDeBeurt = !aanDeBeurt;
        }else{
            speler2.schiet(mouseButton, coordinate2D, new Coordinate2D(50, -30));
            aanDeBeurt = !aanDeBeurt;
        }
    }

    /**
     * Voegt een bom aan het spel toe.
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 23-03-2022
     */
    public void addBom(Bom bom){
        addEntity(bom);
    }


    /**
     * Checkt of dat de muis beweegt. Bij beweging draait de barrel van de speler die aan de beurt is.
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 24-03-2022
     */
    @Override
    public void onMouseMoved(Coordinate2D coordinate2D) {
        if(aanDeBeurt){
            speler1.draaiBarrel(coordinate2D);
        }else{
            speler2.draaiBarrel(coordinate2D);
        }
    }


    /**
     * Updater om te checken wie er dood is. Zet de winconditie, en gaat door naar het eindscherm.
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 28-03-2022
     */
    @Override
    public void explicitUpdate(long l) {
        if(speler1.getHealth() <= 0){
            tankArtillery.setSpeler1Gewonnen(false);
            tankArtillery.setActiveScene(2);
        }
        if(speler2.getHealth() <= 0){
            tankArtillery.setSpeler1Gewonnen(true);
            tankArtillery.setActiveScene(2);
        }
    }
}
