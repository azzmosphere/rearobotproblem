package rea.toyrobot.perspective;

import rea.toyrobot.exceptions.RobotInitialisationException;

/**
 * implementation of EnumPerspectiveCompass factory.
 */

public class PerspectiveCompassFactoryImp implements PerspectiveCompassFactory {
    private String initialPosition;

    @Override
    public void setInitialPosition(String initialPosition) {
        this.initialPosition = initialPosition;
    }

    @Override
    public String getInitialPosition() {
        return initialPosition;
    }

    @Override
    public PerspectiveCompass create() throws RobotInitialisationException {
        PerspectiveCompass object = null;
        for (PerspectiveCompass perspectiveCompass : EnumPerspectiveCompass.values()) {
            if (perspectiveCompass.getCardinalDirection().equals(initialPosition)) {
                object = perspectiveCompass;
                break;
            }
        }
        return object;
    }
}
