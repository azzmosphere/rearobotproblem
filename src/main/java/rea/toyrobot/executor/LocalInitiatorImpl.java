package rea.toyrobot.executor;

import rea.toyrobot.actions.physicalobjects.LocalAction;
import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.physicalobjects.PhysicalObject;

public class LocalInitiatorImpl extends AbstractInitiator<LocalAction> implements LocalInitiator {

    private PhysicalObject currentObject;

    @Override
    public void setCurrentObject(PhysicalObject currentObject) {
        this.currentObject = currentObject;
    }

    @Override
    protected void configureAction(LocalAction action, String[] cmd) {
        action.setPhysicalObject(currentObject);
        action.setArgsIn(cmd);
    }

    @Override
    protected void runAction(LocalAction action) throws RobotException {
        action.runAction();
    }

    @Override
    public boolean verifyAction(String[] cmd) {
        boolean rv = false;

        if (currentObject != null) {
            rv = true;
        }

        return rv;
    }

}
