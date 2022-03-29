package com.github.hanyaeger.tutorial.entities.text;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleText extends TextEntity {

    public TitleText(Coordinate2D initialLocation) {
        super(initialLocation);
        setFont(Font.font("Roboto", FontWeight.BOLD, 50));
        setFill(Color.RED);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
