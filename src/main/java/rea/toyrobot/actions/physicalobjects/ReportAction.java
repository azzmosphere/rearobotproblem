package rea.toyrobot.actions.physicalobjects;

import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.physicalobjects.PhysicalObject;

public class ReportAction implements LocalResponseAction {
    @Override
    public void runAction() throws RobotException {

    }

    @Override
    public void setPhysicalObject(PhysicalObject physicalObject) {

    }

    @Override
    public String[] getReponse() {
        return new String[0];
    }

    @Override
    public void setArgsIn(String[] argsIn) {

    }

    @Override
    public boolean canPerformAction(String[] argsIn) {
        return false;
    }
}
