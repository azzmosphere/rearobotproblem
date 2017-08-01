package rea.toyrobot.factories;

import rea.toyrobot.config.mapper.RobotCompassConfig;
import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.perspective.EnumPerspectiveCompass;
import rea.toyrobot.perspective.PerspectiveCompass;

/**
 * implementation of EnumPerspectiveCompass factory.
 */

public class CompassFactory extends ObjectFactory<PerspectiveCompass, EnumPerspectiveCompass> implements RobotCompassFactory {
    public CompassFactory() {
        super(EnumPerspectiveCompass.class);
    }

    @Override
    protected EnumPerspectiveCompass init(EnumPerspectiveCompass object) throws RobotInitialisationException {
        return null;
    }

    @Override
    public PerspectiveCompass create() throws RobotInitialisationException {
        return super.create();
    }

    @Override
    public void setObjectMapper(RobotCompassConfig mapper) {

    }
}
