package rea.toyrobot.perspective;

import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.factories.ReaObjectFactory;

/**
 * implementation of EnumPerspectiveCompass factory.
 */

public class PerspectiveCompassFactoryImp extends ReaObjectFactory<PerspectiveCompass, EnumPerspectiveCompass> implements PerspectiveCompassFactory {
    private String initialPosition;

    @Override
    public void setInitialPosition(String initialPosition) {
        this.initialPosition = initialPosition;
    }

    @Override
    public String getInitialPosition() {
        return initialPosition;
    }

    public PerspectiveCompassFactoryImp() {
        super(EnumPerspectiveCompass.class);
    }

    @Override
    protected EnumPerspectiveCompass init(EnumPerspectiveCompass object) throws RobotInitialisationException {
        return object;
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
