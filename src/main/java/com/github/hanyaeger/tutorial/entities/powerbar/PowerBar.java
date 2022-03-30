package com.github.hanyaeger.tutorial.entities.powerbar;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class PowerBar extends DynamicCompositeEntity {
    private PowerBarFill powerBarFill;

    public PowerBar(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    /**
     * Zet alle atributen van de powerbar op.
     *
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 28-03-2022
     */

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

    /**
     * Zet de breedte van de powerbar
     *
     * @param width breedte
     * @author Mabel Rutjes, Roward Dorrestijn
     * @since 28-03-2022
     */

    public void setWidth(int width){
        powerBarFill.setFillWidth(width);
    }
}
