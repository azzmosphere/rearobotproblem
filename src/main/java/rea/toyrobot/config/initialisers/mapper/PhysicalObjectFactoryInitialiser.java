package rea.toyrobot.config.initialisers.mapper;

import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.perspective.PerspectiveFactory;
import rea.toyrobot.physicalobjects.PhysicalObjectFactory;

public class PhysicalObjectFactoryInitialiser extends AbstractInitMapper<PhysicalObjectFactory> {
    PerspectiveFactory perspectiveFactory;

    @Override
    public void configure(PhysicalObjectFactory instance) throws RobotInitialisationException {
        instance.setPerspectiveFactory(perspectiveFactory);
    }

    public PhysicalObjectFactoryInitialiser(PerspectiveFactory perspectiveFactory) {
        this.perspectiveFactory = perspectiveFactory;
    }
}
