package com.github.hanyaeger.tutorial.entities.powerbar;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class PowerBar extends DynamicCompositeEntity {
    private int width;

    public PowerBar(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
        var powerBarStroke = new PowerBarStroke(
                new Coordinate2D(0, 0)
        );
        var powerBarFill = new PowerBarFill(
                new Coordinate2D(0, 0), this.width
        );

        addEntity(powerBarStroke);
        addEntity(powerBarFill);
    }

    public void setWidth(int width){
        this.width = width;
    }
}
