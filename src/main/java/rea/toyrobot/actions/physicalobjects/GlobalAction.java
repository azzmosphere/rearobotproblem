package rea.toyrobot.actions.physicalobjects;

import rea.toyrobot.actions.Action;
import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.worlds.World;

public interface GlobalAction extends Action {
    /**
     * sets the world that is to be modified.
     *
     * @param world
     */
    void setWorld(World world);

    /**
     * runs the action.
     *
     * @throws RobotException
     */
    void runAction() throws RobotException;
}
