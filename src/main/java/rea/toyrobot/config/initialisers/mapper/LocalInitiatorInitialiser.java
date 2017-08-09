package rea.toyrobot.config.initialisers.mapper;

/**
 * initialise the local initiator
 */

import rea.toyrobot.config.initialisers.mapper.local.LocalActionInitialiser;
import rea.toyrobot.config.mapper.jabx.ToyRobot;
import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.executor.LocalInitiator;

public class LocalInitiatorInitialiser extends AbstractInitMapper<LocalInitiator> {
    ToyRobot config;

    /**
     * perform any configuration that is required by the local initiator, this includes adding
     * local actions.
     *
     * @param instance
     * @throws RobotInitialisationException
     */
    @Override
    public void configure(LocalInitiator instance) throws RobotInitialisationException {
        for (ToyRobot.ReaLocalInitiator.Action action : config.getReaLocalInitiator().getAction()) {
            instance.addAction((new LocalActionInitialiser()).map(action.getClazz()));
        }
    }

    /**
     * adding the configuration object.
     *
     * @param config
     */
    public LocalInitiatorInitialiser(ToyRobot config) {
        this.config = config;
    }
}
