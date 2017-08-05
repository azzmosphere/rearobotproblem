package rea.toyrobot.executor;

import rea.toyrobot.actions.physicalobjects.LocalAction;
import rea.toyrobot.physicalobjects.PhysicalObject;

public interface LocalInitiator extends Initiator<LocalAction> {
    void setCurrentObject(PhysicalObject currentObject);
}
