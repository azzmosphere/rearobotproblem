package rea.toyrobot.config.initialisers.mapper;

import rea.toyrobot.config.initialisers.mapper.local.LocalActionInitialiser;
import rea.toyrobot.config.mapper.jabx.ToyRobot;
import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.executor.LocalInitiator;

public class LocalInitiatorInitialiser extends AbstractInitMapper<LocalInitiator> {
    ToyRobot config;

    @Override
    public void configure(LocalInitiator instance) throws RobotInitialisationException {
        for (ToyRobot.ReaLocalInitiator.Action action : config.getReaLocalInitiator().getAction()) {
            instance.addAction((new LocalActionInitialiser()).map((String) action.getClazz()));
        }
    }

    public LocalInitiatorInitialiser(ToyRobot config) {
        this.config = config;
    }
}
