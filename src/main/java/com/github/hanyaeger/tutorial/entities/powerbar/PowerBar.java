package com.github.hanyaeger.tutorial.entities.powerbar;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class PowerBar extends DynamicCompositeEntity {
    private PowerBarFill powerBarFill;

    public PowerBar(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
        var powerBarStroke = new PowerBarStroke(
                new Coordinate2D(0, 0)
        );
        powerBarFill = new PowerBarFill(
                new Coordinate2D(0, 0), 0
        );

        addEntity(powerBarStroke);
        addEntity(powerBarFill);
    }

    public void setWidth(int width){
        powerBarFill.setFillWidth(width);
    }
}
