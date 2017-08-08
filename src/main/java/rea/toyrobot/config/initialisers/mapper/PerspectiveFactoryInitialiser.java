package rea.toyrobot.config.initialisers.mapper;

import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.perspective.PerspectiveCompassFactory;
import rea.toyrobot.perspective.PerspectiveFactory;

public class PerspectiveFactoryInitialiser extends AbstractInitMapper<PerspectiveFactory> {
    private PerspectiveCompassFactory perspectiveCompassFactory;

    @Override
    public void configure(PerspectiveFactory instance) throws RobotInitialisationException {
        instance.setCompassFactory(perspectiveCompassFactory);
    }

    public PerspectiveFactoryInitialiser(PerspectiveCompassFactory perspectiveCompassFactory) {
        this.perspectiveCompassFactory = perspectiveCompassFactory;
    }
}
