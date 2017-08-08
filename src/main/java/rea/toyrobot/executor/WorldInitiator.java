package rea.toyrobot.executor;

/**
 * interface for the world initiator
 */

import rea.toyrobot.actions.world.WorldAction;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.worlds.World;

public interface WorldInitiator extends Initiator<WorldAction> {
    /**
     * set the world object
     *
     * @param world
     */
    void setWorld(World world);

    /**
     * return physical object.
     *
     * @return
     */
    PhysicalObject getPhysicalObject();

    /**
     * sets physical object.
     *
     * @param physicalObject
     */
    void setPhysicalObject(PhysicalObject physicalObject);
}
