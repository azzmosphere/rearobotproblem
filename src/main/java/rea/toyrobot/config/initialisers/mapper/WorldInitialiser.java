package rea.toyrobot.config.initialisers.mapper;

import rea.toyrobot.config.mapper.jabx.ToyRobot;
import rea.toyrobot.worlds.World;

public class WorldInitialiser extends AbstractInitMapper<World> {

    private ToyRobot config;

    @Override
    public void configure(World instance) {
        instance.setLength(config.getWorld().getLength());
        instance.setWidth(config.getWorld().getWidth());
    }

    public WorldInitialiser(ToyRobot config) {
        this.config = config;
    }
}
