package rea.toyrobot.config.initialisers.mapper;

/**
 * initialises clients
 */

import rea.toyrobot.client.RobotClient;
import rea.toyrobot.exceptions.RobotInitialisationException;

public class ClientInitialiser extends AbstractInitMapper<RobotClient> {

    /**
     * perform any further configuration that clients need.
     *
     * @param instance
     * @throws RobotInitialisationException
     */
    @Override
    public void configure(RobotClient instance) throws RobotInitialisationException {
    }
}
