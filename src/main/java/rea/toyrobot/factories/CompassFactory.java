package rea.toyrobot.factories;

import rea.toyrobot.config.mapper.RobotCompassConfig;
import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.perspective.EnumPerspectiveCompass;
import rea.toyrobot.perspective.PerspectiveCompass;

/**
 * implementation of EnumPerspectiveCompass factory.
 */

public class CompassFactory extends ObjectFactory<PerspectiveCompass, EnumPerspectiveCompass> implements RobotCompassFactory {
    private RobotCompassConfig mapper;

    public CompassFactory() {
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
