package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.tutorial.scenes.GameLevel;

public class TankArtillery extends YaegerGame {

    public static void main(String[] args){launch(args);}

    @Override
    public void setupGame() {
        setGameTitle("Tankartillery");
        setSize(new Size(1200, 800));
    }

    @Override
    public void setupScenes() {
        addScene(1, new GameLevel());
    }

    public static class HitBox {
    }
}