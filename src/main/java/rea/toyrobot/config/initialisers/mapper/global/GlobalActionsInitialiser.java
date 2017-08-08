package rea.toyrobot.config.initialisers.mapper.global;

/**
 * initialises global actions
 */

import rea.toyrobot.actions.physicalobjects.GlobalAction;
import rea.toyrobot.config.initialisers.mapper.AbstractInitMapper;
import rea.toyrobot.worlds.World;

public class GlobalActionsInitialiser extends AbstractInitMapper<GlobalAction> {
    private World world;

    /**
     *
     * performs any configuration that the global action needs.
     *
     * @param instance
     */
    @Override
    public void configure(GlobalAction instance) {
        instance.setWorld(world);
    }

    /**
     *
     * class constructor
     *
     * @param world
     */
    public GlobalActionsInitialiser(World world) {
        this.world = world;
    }
}
