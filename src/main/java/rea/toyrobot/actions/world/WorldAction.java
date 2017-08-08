package rea.toyrobot.actions.world;

/**
 * modifies the worlds perspective.
 */

import rea.toyrobot.actions.Action;
import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.physicalobjects.PhysicalObjectFactory;
import rea.toyrobot.worlds.World;
import rea.toyrobot.physicalobjects.PhysicalObject;

public interface WorldAction extends Action {

    /**
     * sets the world that is to be modified.
     *
     * @param world
     */
    void setWorld(World world);

    /**
     * run the action
     *
     * @return
     */
    PhysicalObject runAction() throws RobotException;

    void setPhysicalObjectFactory(PhysicalObjectFactory physicalObjectFactory);
}
