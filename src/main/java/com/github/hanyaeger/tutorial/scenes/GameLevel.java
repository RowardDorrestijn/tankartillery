package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseMovedListener;
import com.github.hanyaeger.tutorial.TankArtillery;
import com.github.hanyaeger.tutorial.entities.bommen.Bom;
import com.github.hanyaeger.tutorial.entities.bommen.Bullet;
import com.github.hanyaeger.tutorial.entities.gebouw.Gebouw;
import com.github.hanyaeger.tutorial.entities.luchtobjecten.LuchtObject;
import com.github.hanyaeger.tutorial.entities.luchtobjecten.Vliegtuig;
import com.github.hanyaeger.tutorial.entities.powerbar.PowerBar;
import com.github.hanyaeger.tutorial.entities.spelers.Speler1;
import com.github.hanyaeger.tutorial.entities.spelers.Speler2;
import com.github.hanyaeger.tutorial.entities.tank.Tank;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.entities.text.NameText;
import com.github.hanyaeger.tutorial.spawners.LuchtObjectSpawner;
import javafx.scene.input.MouseButton;

public class GameLevel extends DynamicScene implements MouseButtonPressedListener, MouseMovedListener, EntitySpawnerContainer {
    private Tank speler1;
    private Tank speler2;
    private boolean aanDeBeurt = true; //True = speler1, false = speler2

    private TankArtillery tankArtillery;

    public GameLevel(TankArtillery tankArtillery){this.tankArtillery = tankArtillery;}

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
                new Coordinate2D(100, getHeight()-150), healthtextSpeler1, this, "sprites/tankGroen1.png", powerBarSpeler1
        );

        speler2 = new Speler2(
                new Coordinate2D(getWidth()-246, getHeight()-150), healthtextSpeler2, this, "sprites/tankGroen2.png", powerBarSpeler2
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

    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new LuchtObjectSpawner(getWidth(), getHeight(), this));
    }

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

    public void addBullet(Bom bom){
        addEntity(bom);
    }

    @Override
    public void onMouseMoved(Coordinate2D coordinate2D) {
        if(aanDeBeurt){
            speler1.draaiBarrel(coordinate2D);
        }else{
            speler2.draaiBarrel(coordinate2D);
        }
    }

    public TankArtillery getTankArtillery(){
        return tankArtillery;
    }
}
