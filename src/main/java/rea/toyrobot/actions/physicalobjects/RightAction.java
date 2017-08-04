package rea.toyrobot.actions.physicalobjects;

/**
 * Rotates a physical object clockwise.
 */

import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.physicalobjects.PhysicalObject;

public class RightAction implements LocalAction {
    PhysicalObject physicalObject;

    @Override
    public void runAction() throws RobotException {
        physicalObject.getPerspective().setCompass(
            physicalObject.getPerspective().getCompass().rotateClockwise()
        );
    }

    @Override
    public void setPhysicalObject(PhysicalObject physicalObject) {
        this.physicalObject = physicalObject;
    }
}
