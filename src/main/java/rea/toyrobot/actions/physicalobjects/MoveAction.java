package rea.toyrobot.actions.physicalobjects;

/**
 * moves the object one unit in the direction that it is facing.
 */

import rea.toyrobot.actions.AbstractAction;
import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.exceptions.RobotOutOfBoundsException;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.worlds.World;

public class MoveAction extends AbstractAction implements GlobalAction {
    private World world;
    private PhysicalObject physicalObject;

    private interface MoveEnumIface {
        int resetX(int x);
        int resetY(int y);
    }

    private enum MoveEnum implements MoveEnumIface {
        NORTH {
            @Override
            public String toString() {
                return "NORTH";
            }

            @Override
            public int resetX(int x) {
                return x;
            }

            @Override
            public int resetY(int y) {
                return y + 1;
            }
        },
        EAST {
            @Override
            public String toString() {
                return "EAST";
            }

            @Override
            public int resetX(int x) {
                return x + 1;
            }

            @Override
            public int resetY(int y) {
                return y;
            }
        },
        SOUTH {
            @Override
            public String toString() {
                return "SOUTH";
            }

            @Override
            public int resetX(int x) {
                return x;
            }

            @Override
            public int resetY(int y) {
                return y - 1;
            }
        },
        WEST {
            @Override
            public String toString() {
                return "WEST";
            }

            @Override
            public int resetX(int x) {
                return x - 1;
            }

            @Override
            public int resetY(int y) {
                return y;
            }
        }
    }

    @Override
    public void setWorld(World world) {
        this.world = world;
    }

    @Override
    public void runAction() throws RobotException {
        int x = physicalObject.getPerspective().getXPos(), y = physicalObject.getPerspective().getYpos(),
                origX= physicalObject.getPerspective().getXPos(), origY = physicalObject.getPerspective().getYpos();;
        getResponder().setHasResponse(true);

        for (MoveEnum moveEnum : MoveEnum.values()) {
            if (moveEnum.toString().equals(physicalObject.getPerspective().getCompass().getCardinalDirection())) {
                x = moveEnum.resetX(x);
                y = moveEnum.resetY(y);
                break;
            }
        }

        if (world.canMoveTo(x, y)) {
            physicalObject.getPerspective().setXPos(x);
            physicalObject.getPerspective().setYPos(y);
            world.relocateObject(origX, origY, x , y);
        }
        else {
            // Reset the perspective
            throw new RobotOutOfBoundsException("Unable to move to " + x + ":" + y + " there is all ready a object there");
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
        return (argsIn.length > 0 && "MOVE".equalsIgnoreCase(argsIn[0]));
    }
}
