package rea.toyrobot.actions.physicalobjects;

/**
 * responsible for changing a physical objects perspective
 * of the world
 */

import rea.toyrobot.actions.Action;
import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.physicalobjects.PhysicalObject;

public interface LocalAction extends Action {
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
