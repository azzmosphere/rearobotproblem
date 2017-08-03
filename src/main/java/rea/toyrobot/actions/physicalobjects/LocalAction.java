package rea.toyrobot.actions.physicalobjects;

import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.physicalobjects.PhysicalObject;

public interface LocalAction {
    /**
     * runs the action.
     *
     * @throws RobotException
     */
    void runAction() throws RobotException;

    /**
     * The pysical object to modify
     *
     * @param physicalObject
     */
    void setPhysicalObject(PhysicalObject physicalObject);
}
