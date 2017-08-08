package rea.toyrobot.config.initialisers.mapper.local;

/**
 * initialises the local action
 */

import rea.toyrobot.actions.physicalobjects.LocalAction;
import rea.toyrobot.config.initialisers.mapper.AbstractInitMapper;
import rea.toyrobot.exceptions.RobotInitialisationException;

public class LocalActionInitialiser extends AbstractInitMapper<LocalAction> {

    /**
     * performs any configuration that local actions need
     *
     * @param instance
     * @throws RobotInitialisationException
     */
    @Override
    public void configure(LocalAction instance) throws RobotInitialisationException {
    }
}
