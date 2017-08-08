package rea.toyrobot.config.initialisers.mapper;

/**
 * initialises the perspective factory
 */

import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.perspective.PerspectiveCompassFactory;
import rea.toyrobot.perspective.PerspectiveFactory;

public class PerspectiveFactoryInitialiser extends AbstractInitMapper<PerspectiveFactory> {
    private PerspectiveCompassFactory perspectiveCompassFactory;

    /**
     * perform any configuration
     *
     * @param instance
     * @throws RobotInitialisationException
     */
    @Override
    public void configure(PerspectiveFactory instance) throws RobotInitialisationException {
        instance.setCompassFactory(perspectiveCompassFactory);
    }

    /**
     * class constructor
     *
     * @param perspectiveCompassFactory
     */
    public PerspectiveFactoryInitialiser(PerspectiveCompassFactory perspectiveCompassFactory) {
        this.perspectiveCompassFactory = perspectiveCompassFactory;
    }
}
