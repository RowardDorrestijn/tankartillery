package com.github.hanyaeger.tutorial.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class NameText extends TextEntity {
    /**
     * Zet de text van de nametext
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 28-03-2022
     */
    public NameText(Coordinate2D initialLocation) {
        super(initialLocation);

        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.RED);
    }

    public void setNameText(String naam){setText(naam);}
}
