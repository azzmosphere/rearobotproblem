package rea.toyrobot.config.initialisers;

import rea.toyrobot.config.mapper.jabx.ToyRobot;
import rea.toyrobot.exceptions.RobotInitialisationException;

public interface ReaUnMarshaller {
    void readConfigProperties() throws RobotInitialisationException;
    ToyRobot getToyRobotConfig();
}
