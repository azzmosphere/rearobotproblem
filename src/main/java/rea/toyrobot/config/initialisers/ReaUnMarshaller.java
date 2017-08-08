package rea.toyrobot.config.initialisers;

/**
 * interface for REA un marshaller
 */

import rea.toyrobot.config.mapper.jabx.ToyRobot;
import rea.toyrobot.exceptions.RobotInitialisationException;

public interface ReaUnMarshaller {
    /**
     * reads configuration.
     *
     * @throws RobotInitialisationException
     */
    void readConfigProperties() throws RobotInitialisationException;

    /**
     * returns the configuration as a object
     *
     * @return
     */
    ToyRobot getToyRobotConfig();
}
