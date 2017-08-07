package rea.toyrobot.actions.physicalobjects;

import rea.toyrobot.actions.AbstractAction;
import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.physicalobjects.PhysicalObject;

public class ReportAction extends AbstractAction implements LocalAction {
    @Override
    public void runAction() throws RobotException {

    }

    @Override
    public void setPhysicalObject(PhysicalObject physicalObject) {

    }

    @Override
    public void setArgsIn(String[] argsIn) {

    }

    @Override
    public boolean canPerformAction(String[] argsIn) {
        return false;
    }
}
