package rea.toyrobot.config.initialisers.mapper;

/**
 * initialises the world initiator.
 */

import rea.toyrobot.config.mapper.jabx.ToyRobot;
import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.worlds.World;

public class WorldInitialiser extends AbstractInitMapper<World> {

    private ToyRobot config;

    /**
     * perform any needed configuration
     *
     * @param instance
     * @throws RobotInitialisationException
     */
    @Override
    public void configure(World instance) throws RobotInitialisationException {
        instance.setLength(config.getWorld().getLength());
        instance.setWidth(config.getWorld().getWidth());
        instance.initialise();
    }

    /**
     *
     * set the configuration object.
     *
     * @param config
     */
    public WorldInitialiser(ToyRobot config) {
        this.config = config;
    }
}
