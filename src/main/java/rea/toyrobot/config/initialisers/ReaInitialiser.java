package rea.toyrobot.config.initialisers;

import rea.toyrobot.client.RobotClient;
import rea.toyrobot.config.mapper.jabx.ToyRobot;
import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.executor.GlobalInitiator;
import rea.toyrobot.executor.LocalInitiator;
import rea.toyrobot.executor.WorldInitiator;
import rea.toyrobot.worlds.World;
import java.util.List;
import rea.toyrobot.config.initialisers.mapper.WorldInitialiser;

public class ReaInitialiser implements Initialiser {
    private ReaUnMarshaller reaUnMarshaller;
    private World world;

    @Override
    public void initialise() throws RobotInitialisationException {
        reaUnMarshaller.readConfigProperties();
        ToyRobot config = reaUnMarshaller.getToyRobotConfig();
        world = (new WorldInitialiser(config)).map(config.getWorld().getClazz());

    }

    @Override
    public List<RobotClient> getClients() {
        return null;
    }

    @Override
    public void setReaUnMarshaller(ReaUnMarshaller reaUnMarshaller) {
        this.reaUnMarshaller = reaUnMarshaller;
    }

    @Override
    public WorldInitiator getWorldInitiator() {
        return null;
    }

    @Override
    public GlobalInitiator getGlobalInitator() {
        return null;
    }

    @Override
    public LocalInitiator getLocalInitiator() {
        return null;
    }
}
