package com.github.hanyaeger.tutorial.entities.buttons.colorbuttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.TankArtillery;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class ColorButtonSpeler2 extends DynamicRectangleEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private TankArtillery tankArtillery;
    private String entitieString;
    private boolean selected = false;

    public ColorButtonSpeler2(TankArtillery tankArtillery, Coordinate2D initialLocation, String entitieString, Color kleur) {
        super(initialLocation);
        this.tankArtillery = tankArtillery;
        this.entitieString = entitieString;
        setWidth(100);
        setHeight(100);
        setStrokeColor(Color.BLACK);
        setFill(kleur);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        tankArtillery.setKleurSpeler2(entitieString);
    }

    @Override
    public void onMouseEntered() {
        setStrokeWidth(10);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setStrokeWidth(1);
        setCursor(Cursor.DEFAULT);
    }
}
