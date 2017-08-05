package rea.toyrobot.executor;

import rea.toyrobot.actions.world.WorldAction;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.worlds.World;

public interface WorldInitiator extends Initiator<WorldAction> {
    void setWorld(World world);
    PhysicalObject getPhysicalObject();
    void setPhysicalObject(PhysicalObject physicalObject);
}
