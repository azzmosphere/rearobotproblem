package rea.toyrobot.actions.physicalobjects;

import rea.toyrobot.exceptions.RobotException;

public interface LocalAction {
    /**
     * runs the action.
     *
     * @throws RobotException
     */
    void runAction() throws RobotException;
}
