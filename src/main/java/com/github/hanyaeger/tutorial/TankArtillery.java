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


    public boolean isSpeler1Gewonnen() {
        return speler1Gewonnen;
    }

    public void setSpeler1Gewonnen(boolean speler1Gewonnen) {
        this.speler1Gewonnen = speler1Gewonnen;
    }
}