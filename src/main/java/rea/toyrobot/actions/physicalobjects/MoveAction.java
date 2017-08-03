package rea.toyrobot.actions.physicalobjects;

/**
 * moves the object one unit.
 */

import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.worlds.World;

public class MoveAction implements GlobalAction {
    private World world;
    private PhysicalObject physicalObject;

    @Override
    public void setWorld(World world) {
        this.world = world;
    }

    @Override
    public void runAction() throws RobotException {
        int x = physicalObject.getPerspective().getXPos(), y = physicalObject.getPerspective().getYpos();

//        if (world.canMoveTo(x, y + 1) && "NORTH".equals(physicalObject.getPerspective().getCompass().getCardinalDirection())) {
            physicalObject.getPerspective().setYPos(y + 1);
//        }
    }

    @Override
    public void setPhysicalObject(PhysicalObject physicalObject) {
        this.physicalObject = physicalObject;
    }
}
