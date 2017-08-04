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

    @Override
    public void setArgsIn(String[] argsIn) {

    }

    @Override
    public boolean canPerformAction(String[] argsIn) {
        return (argsIn.length > 0 && "RIGHT".equalsIgnoreCase(argsIn[0]));
    }
}
