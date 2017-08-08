package rea.toyrobot.config.initialisers.mapper.world;

/**
 * initialises a world actions
 */

import rea.toyrobot.actions.world.WorldAction;
import rea.toyrobot.config.initialisers.mapper.AbstractInitMapper;
import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.physicalobjects.PhysicalObjectFactory;
import rea.toyrobot.worlds.World;

public class WorldActionInialiser extends AbstractInitMapper<WorldAction> {
    private PhysicalObjectFactory physicalObjectFactory;
    private World world;

    /**
     * performs any configuration that world actions need.
     *
     * @param instance
     * @throws RobotInitialisationException
     */
    @Override
    public void configure(WorldAction instance) throws RobotInitialisationException {
        instance.setPhysicalObjectFactory(physicalObjectFactory);
        instance.setWorld(world);
    }

    /**
     * class constructor
     *
     * @param physicalObjectFactory
     * @param world
     */
    public WorldActionInialiser(PhysicalObjectFactory physicalObjectFactory, World world) {
        this.world = world;
        this.physicalObjectFactory = physicalObjectFactory;
    }
}
