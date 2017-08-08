package rea.toyrobot.config.initialisers.mapper;

import rea.toyrobot.config.initialisers.mapper.world.WorldActionInialiser;
import rea.toyrobot.config.mapper.jabx.ToyRobot;
import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.executor.WorldInitiator;
import rea.toyrobot.physicalobjects.PhysicalObjectFactory;
import rea.toyrobot.worlds.World;

public class WorldInitiatorInitialiser extends AbstractInitMapper<WorldInitiator> {
    private World world;
    private PhysicalObjectFactory physicalObjectFactory;
    private ToyRobot config;

    @Override
    public void configure(WorldInitiator instance) throws RobotInitialisationException {
        WorldActionInialiser worldActionInialiser = new WorldActionInialiser(physicalObjectFactory, world);
        instance.setWorld(world);

        for (ToyRobot.ReaWorldInitiator.Action action : config.getReaWorldInitiator().getAction()) {
            instance.addAction(worldActionInialiser.map(action.getClazz()));
        }
    }

    public WorldInitiatorInitialiser(ToyRobot config, World world, PhysicalObjectFactory physicalObjectFactory) {
        this.config = config;
        this.world = world;
        this.physicalObjectFactory = physicalObjectFactory;
    }
}
