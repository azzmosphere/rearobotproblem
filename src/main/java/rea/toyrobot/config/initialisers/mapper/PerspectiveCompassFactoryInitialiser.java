package rea.toyrobot.config.initialisers.mapper;

/**
 * initilises the perspective compass factory.
 */

import rea.toyrobot.config.mapper.jabx.ToyRobot;
import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.perspective.PerspectiveCompassFactory;

public class PerspectiveCompassFactoryInitialiser extends AbstractInitMapper<PerspectiveCompassFactory> {
    private  ToyRobot config;

    /**
     * configure a perspective compass instance
     *
     * @param instance
     * @throws RobotInitialisationException
     */
    @Override
    public void configure(PerspectiveCompassFactory instance) throws RobotInitialisationException {
        instance.setInitialPosition(config.getCompassFactory().getInitialPosition());
    }

    /**
     * add the configuration object.
     *
     * @param config
     */
    public PerspectiveCompassFactoryInitialiser(ToyRobot config) {
        this.config = config;
    }
}
