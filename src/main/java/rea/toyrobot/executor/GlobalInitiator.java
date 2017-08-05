package rea.toyrobot.executor;

import rea.toyrobot.actions.physicalobjects.GlobalAction;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.worlds.World;

public interface GlobalInitiator extends Initiator<GlobalAction> {
    void setWorld(World world);

    void setPhysicalObject(PhysicalObject physicalObject);
}
