package rea.toyrobot.executor;

/**
 * interface for global initiator
 */

import rea.toyrobot.actions.physicalobjects.GlobalAction;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.worlds.World;

public interface GlobalInitiator extends Initiator<GlobalAction> {
    /**
     * set world.
     *
     * @param world
     */
    void setWorld(World world);

    /**
     * set physical object.
     *
     * @param physicalObject
     */
    void setPhysicalObject(PhysicalObject physicalObject);
}
