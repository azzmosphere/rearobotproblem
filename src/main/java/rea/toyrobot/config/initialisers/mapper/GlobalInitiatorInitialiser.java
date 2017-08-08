package rea.toyrobot.config.initialisers.mapper;

import rea.toyrobot.actions.physicalobjects.GlobalAction;
import rea.toyrobot.config.initialisers.mapper.global.GlobalActionsInitialiser;
import rea.toyrobot.config.mapper.jabx.ToyRobot;
import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.executor.GlobalInitiator;
import rea.toyrobot.worlds.World;

public class GlobalInitiatorInitialiser extends AbstractInitMapper<GlobalInitiator> {
    private ToyRobot config;
    private World world;
    private GlobalActionsInitialiser globalActionsInitialiser;

    public GlobalInitiatorInitialiser(ToyRobot config, World world) {
        this.config = config;
        this.world = world;
    }

    @Override
    public void configure(GlobalInitiator instance) throws RobotInitialisationException {
        instance.setWorld(world);
        globalActionsInitialiser = new GlobalActionsInitialiser(world);

        for (ToyRobot.ReaGlobalInitiator.Action action : config.getReaGlobalInitiator().getAction()) {
            GlobalAction globalAction = globalActionsInitialiser.map((String) action.getClazz());
            globalAction.setWorld(world);
            instance.addAction(globalAction);
        }
    }
}
