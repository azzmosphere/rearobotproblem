package rea.toyrobot.executor;

import rea.toyrobot.actions.world.WorldAction;
import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.physicalobjects.PhysicalObjectFactory;
import rea.toyrobot.worlds.World;

public class WorldInitiator extends AbstractInitiator<WorldAction> {
    @Override
    protected void configureAction(WorldAction action, String[] cmd) {

    }

    @Override
    protected void runAction(WorldAction action) throws RobotException {

    }

    @Override
    public boolean verifyAction(String[] cmd) {
        return false;
    }

    /**
     * Sets the World environment.
     *
     * @param world
     */
    public void setWorld(World world) {

    }

    /**
     *
     * Physical object factory to use when creating physical objects.
     *
     * @param physicalObjectFactory
     */
    public void setPhysicalObjectFactory(PhysicalObjectFactory physicalObjectFactory) {

    }

    /**
     * returns the current physical obi]ject created.
     *
     * @return
     */
    public PhysicalObject getPhysicalObject() {
        return null;
    }
}

