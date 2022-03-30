package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.TankArtillery;
import com.github.hanyaeger.tutorial.entities.buttons.PlayAgainButton;
import com.github.hanyaeger.tutorial.entities.buttons.QuitButton;
import com.github.hanyaeger.tutorial.entities.text.TitleText;

public class GameOver extends StaticScene {

    private TankArtillery tankArtillery;

    public GameOver(TankArtillery tankArtillery){
        this.tankArtillery = tankArtillery;
    }

    /**
     * Maakt het eindscherm aan. Maakt teksten en knoppen aan.
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 29-03-2022
     */

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

        var playAgainButton = new PlayAgainButton(
                tankArtillery, new Coordinate2D(
                        getWidth()/2, getHeight()/2
            )
        );
        playAgainButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        var quitButton = new QuitButton(
                tankArtillery, new Coordinate2D(
                getWidth()/2, getHeight()/2 + 80
        )
        );
        quitButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        setupWinnerText();

        addEntity(titleText);
        addEntity(playAgainButton);
        addEntity(quitButton);
    }

    /**
     * Checkt wie er gewonnen heeft aan de hand van isSpeler1Gewonnen().
     * Bij true wint speler1 en bij false speler 2.
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 29-03-2022
     */

    public void setupWinnerText(){
        String winnerText;
        if(tankArtillery.isSpeler1Gewonnen()){
            winnerText = "Speler 1 heeft gewonnen!";
        }else{
          winnerText = "Speler 2 heeft gewonnen!";
        }

        var winnerTextGameOver = new TitleText(
                new Coordinate2D(getWidth()/2, 150)
        );

        winnerTextGameOver.setText(winnerText);
        addEntity(winnerTextGameOver);
    }
}
