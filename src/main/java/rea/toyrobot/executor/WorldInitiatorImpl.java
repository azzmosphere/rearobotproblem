package rea.toyrobot.executor;

import rea.toyrobot.actions.world.WorldAction;
import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.worlds.World;

public class WorldInitiatorImpl extends AbstractInitiator<WorldAction> implements WorldInitiator {
    private PhysicalObject physicalObject;
    private World world;

    @Override
    protected void configureAction(WorldAction action, String[] cmd) {
        action.setArgsIn(cmd);
        action.setWorld(world);
    }

    @Override
    protected void runAction(WorldAction action) throws RobotException {
        physicalObject = action.runAction();
    }

    @Override
    public boolean verifyAction(String[] cmd) {
        return (world != null);
    }

    /**
     * Sets the World environment.
     *
     * @param world
     */
    @Override
    public void setWorld(World world) {
        this.world = world;
    }

    /**
     * returns the current physical obi]ject created.
     *
     * @return
     */
    @Override
    public PhysicalObject getPhysicalObject() {
        return physicalObject;
    }

    @Override
    public void setPhysicalObject(PhysicalObject physicalObject) {
        this.physicalObject = physicalObject;
    }
}

