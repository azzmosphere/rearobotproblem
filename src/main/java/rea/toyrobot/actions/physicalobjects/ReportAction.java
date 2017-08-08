package rea.toyrobot.actions.physicalobjects;

/**
 * describe the physical objects perspective of the world.
 */

import rea.toyrobot.actions.AbstractAction;
import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.responder.RobotResponder;

public class ReportAction extends AbstractAction implements LocalAction {
    private PhysicalObject physicalObject;

    @Override
    public void runAction() throws RobotException {
        try {
            RobotResponder responder = getResponder();
            responder.setHasResponse(true);
            responder.setResponse(physicalObject.getPerspective().getXPos() + "," + physicalObject.getPerspective().getYpos() + "," + physicalObject.getPerspective().getCompass().getCardinalDirection());
        }
        catch (Exception e) {
            throw new RobotException("a unchecked exception has occurred " + e.getMessage());
        }
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
        return (argsIn.length > 0 && "REPORT".equalsIgnoreCase(argsIn[0]));
    }
}
