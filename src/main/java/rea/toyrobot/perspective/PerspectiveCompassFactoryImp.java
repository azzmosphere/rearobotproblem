package rea.toyrobot.perspective;

import rea.toyrobot.config.mapper.RobotCompassConfig;
import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.factories.ObjectFactory;

/**
 * implementation of EnumPerspectiveCompass factory.
 */

public class PerspectiveCompassFactoryImp extends ObjectFactory<PerspectiveCompass, EnumPerspectiveCompass> implements PerspectiveCompassFactory {
    private RobotCompassConfig mapper;

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
            if (perspectiveCompass.getCardinalDirection().equals(mapper.getInitialpos())) {
                object = perspectiveCompass;
                break;
            }
        }
        return object;
    }

    @Override
    public void setObjectMapper(RobotCompassConfig mapper) {
        this.mapper = mapper;
    }
}
