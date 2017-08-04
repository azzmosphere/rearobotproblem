package rea.toyrobot.actions.physicalobjects;

/**
 * Moves a physical object 90 degrees to its left hand side.
 */

import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.physicalobjects.PhysicalObject;

public class LeftAction implements LocalAction {

    private PhysicalObject physicalObject;

    @Override
    public void runAction() throws RobotException {
        physicalObject.getPerspective().setCompass(
            physicalObject.getPerspective().getCompass().rotateAntiClockwise()
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
        return false;
    }
}
