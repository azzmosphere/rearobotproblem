package rea.toyrobot.executor;

import rea.toyrobot.actions.world.WorldAction;
import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.physicalobjects.PhysicalObjectFactory;
import rea.toyrobot.worlds.World;

public class WorldInitiator extends AbstractInitiator<WorldAction> {
    private PhysicalObject physicalObject;
    private PhysicalObjectFactory physicalObjectFactory;
    private World world;

    @Override
    protected void configureAction(WorldAction action, String[] cmd) {
        action.setArgsIn(cmd);
        action.setWorld(world);
        action.setPhysicalObjectFactory(physicalObjectFactory);
    }

    @Override
    protected void runAction(WorldAction action) throws RobotException {
        physicalObject = action.runAction();
    }

    @Override
    public boolean verifyAction(String[] cmd) {
        return (physicalObjectFactory != null && world != null);
    }

    /**
     * Sets the World environment.
     *
     * @param world
     */
    public void setWorld(World world) {
        this.world = world;
    }

    /**
     *
     * Physical object factory to use when creating physical objects.
     *
     * @param physicalObjectFactory
     */
    public void setPhysicalObjectFactory(PhysicalObjectFactory physicalObjectFactory) {
        this.physicalObjectFactory = physicalObjectFactory;
    }

    /**
     * returns the current physical obi]ject created.
     *
     * @return
     */
    public PhysicalObject getPhysicalObject() {
        return physicalObject;
    }
}

