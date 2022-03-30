package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.tutorial.scenes.GameLevel;
import com.github.hanyaeger.tutorial.scenes.GameOver;
import com.github.hanyaeger.tutorial.scenes.TitleScene;

public class TankArtillery extends YaegerGame {

    private String kleurSpeler1;
    private String kleurSpeler2;

    private boolean speler1Gewonnen;

    public static void main(String[] args){launch(args);}

    /**
     * Maakt de game aan en maakt scenes aan.
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 21-03-2022
     */

    @Override
    public void setupGame() {
        setGameTitle("Tankartillery");
        setSize(new Size(1200, 800));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameLevel(this));
        addScene(2, new GameOver(this));
    }

    /**
     * Returnt en zet de kleuren van speler1 en speler2.
     * Wordt gebruikt bij het maken van tanks in GameLevel.
     *
     * @author Mabel Rutjes, Roward Dorrestijn
     *
     * @param kleurSpeler1 kleur van speler 1
     * @param kleurSpeler2 kleur van speler 2
     *
     * @since 29-03-2022
     */

    public String getKleurSpeler1() {
        return kleurSpeler1;
    }

    public void setKleurSpeler1(String kleurSpeler1) {
        this.kleurSpeler1 = kleurSpeler1;
    }

    public String getKleurSpeler2() {
        return kleurSpeler2;
    }

    public void setKleurSpeler2(String kleurSpeler2) {
        this.kleurSpeler2 = kleurSpeler2;
    }

    /**
     * Returnt en zet de winconditie van speler1.
     * Bij return == true wint speler 1. Bij return == false wint speler 2.
     *
     * @author Mabel Rutjes, Roward Dorrestijn
     * @param speler1Gewonnen true or false
     *
     * @since 29-03-2022
     */

    public boolean isSpeler1Gewonnen() {
        return speler1Gewonnen;
    }

    public void setSpeler1Gewonnen(boolean speler1Gewonnen) {
        this.speler1Gewonnen = speler1Gewonnen;
    }
}