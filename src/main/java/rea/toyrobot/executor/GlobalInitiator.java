package rea.toyrobot.executor;

import rea.toyrobot.actions.physicalobjects.GlobalAction;
import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.worlds.World;

public class GlobalInitiator extends AbstractInitiator<GlobalAction> {
    @Override
    protected void configureAction(GlobalAction action, String[] cmd) {

    }

    @Override
    protected void runAction(GlobalAction action) throws RobotException {

    }

    @Override
    public boolean verifyAction(String[] cmd) {
        return false;
    }

    public void setWorld(World world) {

    }

    public void setPhysicalObject(PhysicalObject physicalObject) {

    }
}
