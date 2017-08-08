package rea.toyrobot.config.initialisers.mapper;

/**
 * initialise the physical object factory
 */

import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.perspective.PerspectiveFactory;
import rea.toyrobot.physicalobjects.PhysicalObjectFactory;

public class PhysicalObjectFactoryInitialiser extends AbstractInitMapper<PhysicalObjectFactory> {
    PerspectiveFactory perspectiveFactory;

    /**
     * perform any configuration
     *
     * @param instance
     * @throws RobotInitialisationException
     */
    @Override
    public void configure(PhysicalObjectFactory instance) throws RobotInitialisationException {
        instance.setPerspectiveFactory(perspectiveFactory);
    }

    /**
     * class constructor
     *
     * @param perspectiveFactory
     */
    public PhysicalObjectFactoryInitialiser(PerspectiveFactory perspectiveFactory) {
        this.perspectiveFactory = perspectiveFactory;
    }
}
