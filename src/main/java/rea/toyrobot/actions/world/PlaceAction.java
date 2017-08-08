package rea.toyrobot.actions.world;

/**
 * The PlaceAction places a physical object in the world and adjusts that
 * objects perspective to match its position in the world.
 */

import rea.toyrobot.actions.AbstractAction;
import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.physicalobjects.PhysicalObjectFactory;
import rea.toyrobot.worlds.World;

public class PlaceAction extends AbstractAction implements WorldAction {
    private String[] argsIn;
    private PhysicalObjectFactory physicalObjectFactory;
    private World world;

    @Override
    public void setWorld(World world) {
        this.world = world;
    }

    @Override
    public PhysicalObject runAction() throws RobotException {
        PhysicalObject physicalObject = null;
        try {
            String[] args = argsIn[1].split(",");
            int x = Integer.parseInt(args[0]), y = Integer.parseInt(args[1]);
            getResponder().setHasResponse(true);

            if (physicalObject != null && physicalObject.getPerspective().getCompass().findCardinalDirection(args[2]) == null) {
                getResponder().setResponse("WARN: unsupported compass direction");
            }
            else if (world.canMoveTo(x, y)) {
                world.setObject(x, y);

                physicalObject = physicalObjectFactory.create();
                physicalObject.getPerspective().setXPos(x);
                physicalObject.getPerspective().setYPos(y);
                physicalObject.getPerspective().setCompass(
                    physicalObject.getPerspective().getCompass().findCardinalDirection(args[2])
                );
            }
            else {
                getResponder().setResponse("WARN: Unable to move to " + x + ":" + y);
            }
        }
        catch (RobotException e) {
            throw e;
        }
        catch (Exception e) {
            throw new RobotInitialisationException("an unchecked error has occurred :" + e.getMessage());
        }


        return physicalObject;
    }

    @Override
    public void setArgsIn(String[] argsIn) {
        this.argsIn = argsIn;
    }

    @Override
    public void setPhysicalObjectFactory(PhysicalObjectFactory physicalObjectFactory) {
        this.physicalObjectFactory = physicalObjectFactory;
    }

    @Override
    public boolean canPerformAction(String[] argsIn) {
        boolean rv = false;
        if (argsIn.length > 0 && argsIn[0] != null && "PLACE".equalsIgnoreCase(argsIn[0])) {
            rv = true;
        }
        return rv;
    }
}
