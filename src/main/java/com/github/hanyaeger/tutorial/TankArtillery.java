package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class TankArtillery extends YaegerGame {
    public static void main(String[] args){launch(args);}

    @Override
    public void setupGame() {
        setGameTitle("Tankartillery");
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes() {

    }
}