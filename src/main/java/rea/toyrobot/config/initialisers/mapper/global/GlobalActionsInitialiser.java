package rea.toyrobot.config.initialisers.mapper.global;

import rea.toyrobot.actions.physicalobjects.GlobalAction;
import rea.toyrobot.config.initialisers.mapper.AbstractInitMapper;
import rea.toyrobot.worlds.World;

public class GlobalActionsInitialiser extends AbstractInitMapper<GlobalAction> {
    private World world;

    @Override
    public void configure(GlobalAction instance) {
        instance.setWorld(world);
    }

    public GlobalActionsInitialiser(World world) {
        this.world = world;
    }
}
