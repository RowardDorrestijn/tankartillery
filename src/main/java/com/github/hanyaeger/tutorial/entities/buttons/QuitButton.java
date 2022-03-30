package com.github.hanyaeger.tutorial.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.TankArtillery;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class QuitButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private TankArtillery tankArtillery;

    public QuitButton(TankArtillery tankArtillery, Coordinate2D initialLocation){
        super(initialLocation,"Quit");
        this.tankArtillery = tankArtillery;
        setFill(Color.ORANGE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    /**
     * Sluit het spel af.
     *
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 29-03-2022
     */

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        tankArtillery.quit();
    }

    /**
     * Verandert de kleur bij interactie met de muis.
     *
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 29-03-2022
     */

    @Override
    public void onMouseEntered(){
        setFill(Color.YELLOW);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited(){
        setFill(Color.ORANGE);
        setCursor(Cursor.DEFAULT);
    }
}
