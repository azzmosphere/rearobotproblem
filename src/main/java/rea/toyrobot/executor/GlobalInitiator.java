package rea.toyrobot.executor;

import rea.toyrobot.actions.physicalobjects.GlobalAction;
import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.worlds.World;

public class GlobalInitiator extends AbstractInitiator<GlobalAction> {
    private World world;
    private PhysicalObject physicalObject;

    @Override
    protected void configureAction(GlobalAction action, String[] cmd) {
        action.setWorld(world);
        action.setPhysicalObject(physicalObject);
        action.setArgsIn(cmd);
    }

    @Override
    protected void runAction(GlobalAction action) throws RobotException {
        action.runAction();
    }

    @Override
    public boolean verifyAction(String[] cmd) {
        boolean rv = true;
        if (world == null || physicalObject == null) {
            rv = false;
        }
        return rv;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public void setPhysicalObject(PhysicalObject physicalObject) {
        this.physicalObject = physicalObject;
    }
}
