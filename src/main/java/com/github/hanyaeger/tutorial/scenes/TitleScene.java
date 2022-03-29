package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.TankArtillery;
import com.github.hanyaeger.tutorial.entities.buttons.StartButton;
import com.github.hanyaeger.tutorial.entities.buttons.colorbuttons.ColorButtonSpeler1;
import com.github.hanyaeger.tutorial.entities.buttons.colorbuttons.ColorButtonSpeler2;
import com.github.hanyaeger.tutorial.entities.text.TitleText;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class TitleScene extends StaticScene {

    private TankArtillery tankArtillery;

    public TitleScene(TankArtillery tankArtillery){
        this.tankArtillery = tankArtillery;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/achtergrond.png");
    }

    @Override
    public void setupEntities() {
        var titleText = new TitleText(
                new Coordinate2D(getWidth() / 2, 100)
        );
        titleText.setText("Tank Artillery");

        var startButton = new StartButton(tankArtillery,
                new Coordinate2D(getWidth() / 2, getHeight() - 100)
        );
        startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        var speler1Text = new TitleText(
                new Coordinate2D(150, 320)
        );
        speler1Text.setText("Speler 1");


        var speler2Text = new TitleText(
                new Coordinate2D(150, 470)
        );
        speler2Text.setText("Speler 2");

        setupColorButtons();

        addEntity(speler1Text);
        addEntity(speler2Text);
        addEntity(titleText);
        addEntity(startButton);
    }

    void setupColorButtons(){
        double coordX = 200;
        double coordY = 300;
        for(int kleur = 0; kleur < 4; kleur++){
            coordX += 150;
            switch (kleur){
                case 0:

                    var paarsButtonSpeler1 = new ColorButtonSpeler1(
                            tankArtillery, new Coordinate2D(coordX, coordY), "sprites/tankPaars1.png", Color.PURPLE
                    );

                    var paarsButtonSpeler2 = new ColorButtonSpeler2(
                            tankArtillery, new Coordinate2D(coordX, coordY + 150), "sprites/tankPaars2.png", Color.PURPLE
                    );

                    addEntity(paarsButtonSpeler1);
                    addEntity(paarsButtonSpeler2);

                    break;
                case 1:
                    var rozeButtonSpeler1 = new ColorButtonSpeler1(
                            tankArtillery, new Coordinate2D(coordX, coordY), "sprites/tankRoze1.png", Color.PINK
                    );
                    var rozeButtonSpeler2 = new ColorButtonSpeler2(
                            tankArtillery, new Coordinate2D(coordX, coordY + 150), "sprites/tankRoze2.png", Color.PINK
                    );

                    addEntity(rozeButtonSpeler1);
                    addEntity(rozeButtonSpeler2);
                    break;

                case 2:
                    var groenButtonSpeler1 = new ColorButtonSpeler1(
                            tankArtillery, new Coordinate2D(coordX, coordY), "sprites/tankGroen1.png", Color.GREEN
                    );
                    var groenButtonSpeler2 = new ColorButtonSpeler2(
                            tankArtillery, new Coordinate2D(coordX, coordY + 150), "sprites/tankGroen2.png", Color.GREEN
                    );

                    addEntity(groenButtonSpeler1);
                    addEntity(groenButtonSpeler2);
                    break;

                case 3:
                    var blauwButtonSpeler1 = new ColorButtonSpeler1(
                            tankArtillery, new Coordinate2D(coordX, coordY), "sprites/tankBlauw1.png", Color.BLUE
                    );
                    var blauwButtonSpeler2 = new ColorButtonSpeler2(
                            tankArtillery, new Coordinate2D(coordX, coordY + 150), "sprites/tankBlauw2.png", Color.BLUE
                    );

                    addEntity(blauwButtonSpeler1);
                    addEntity(blauwButtonSpeler2);
                    break;
            }
        }
    }
}
