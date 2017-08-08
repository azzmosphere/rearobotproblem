package rea.toyrobot.config.initialisers.mapper;

import rea.toyrobot.config.mapper.jabx.ToyRobot;
import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.perspective.PerspectiveCompassFactory;

public class PerspectiveCompassFactoryInitialiser extends AbstractInitMapper<PerspectiveCompassFactory> {
    private  ToyRobot config;

    @Override
    public void configure(PerspectiveCompassFactory instance) throws RobotInitialisationException {
        instance.setInitialPosition(config.getCompassFactory().getInitialPosition());
    }

    public PerspectiveCompassFactoryInitialiser(ToyRobot config) {
        this.config = config;
    }
}
