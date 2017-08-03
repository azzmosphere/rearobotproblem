package rea.toyrobot.actions.world;

import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.physicalobjects.PhysicalObjectFactory;
import rea.toyrobot.worlds.World;

public class PlaceAction implements WorldAction {
    @Override
    public void setWorld(World world) {

    }

    @Override
    public PhysicalObject runAction() throws RobotException {
        return null;
    }

    @Override
    public void setArgsIn(String[] argsIn) {

    }

    @Override
    public String[] getResponse() {
        return new String[0];
    }

    @Override
    public void setPhysicalObjectFactory(PhysicalObjectFactory physicalObjectFactory) {

    }

    @Override
    public boolean canPerformAction(String[] argsIn) {
        return false;
    }
}
