package rea.toyrobot.config.initialisers.mapper;

import rea.toyrobot.config.mapper.jabx.ToyRobot;
import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.worlds.World;

public class WorldInitialiser extends AbstractInitMapper<World> {

    private ToyRobot config;

    @Override
    public void configure(World instance) throws RobotInitialisationException {
        instance.setLength(config.getWorld().getLength());
        instance.setWidth(config.getWorld().getWidth());
        instance.initialise();
    }

    public WorldInitialiser(ToyRobot config) {
        this.config = config;
    }
}
