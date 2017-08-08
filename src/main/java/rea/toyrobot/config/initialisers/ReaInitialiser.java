package rea.toyrobot.config.initialisers;

/**
 * Initialises objects from configuration file.
 */

import rea.toyrobot.client.RobotClient;
import rea.toyrobot.config.initialisers.mapper.PhysicalObjectFactoryInitialiser;
import rea.toyrobot.config.mapper.jabx.ToyRobot;
import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.executor.GlobalInitiator;
import rea.toyrobot.executor.LocalInitiator;
import rea.toyrobot.executor.WorldInitiator;
import rea.toyrobot.perspective.PerspectiveCompassFactory;
import rea.toyrobot.perspective.PerspectiveFactory;
import rea.toyrobot.physicalobjects.PhysicalObjectFactory;
import rea.toyrobot.worlds.World;
import java.util.List;
import java.util.ArrayList;
import rea.toyrobot.config.initialisers.mapper.WorldInitialiser;
import rea.toyrobot.config.initialisers.mapper.GlobalInitiatorInitialiser;
import rea.toyrobot.config.initialisers.mapper.WorldInitiatorInitialiser;
import rea.toyrobot.config.initialisers.mapper.PerspectiveFactoryInitialiser;
import rea.toyrobot.config.initialisers.mapper.PerspectiveCompassFactoryInitialiser;
import rea.toyrobot.config.initialisers.mapper.LocalInitiatorInitialiser;
import rea.toyrobot.config.initialisers.mapper.ClientInitialiser;

public class ReaInitialiser implements Initialiser {
    private ReaUnMarshaller reaUnMarshaller;
    private GlobalInitiator globalInitiator;
    private WorldInitiator worldInitiator;
    private LocalInitiator localInitiator;
    private List<RobotClient> clients;

    /**
     * peforms the configuration of the factories, initiators and clients
     *
     * @throws RobotInitialisationException
     */
    @Override
    public void initialise() throws RobotInitialisationException {
        reaUnMarshaller.readConfigProperties();
        ToyRobot config = reaUnMarshaller.getToyRobotConfig();

        /* create factories */
        World world = (new WorldInitialiser(config)).map(config.getWorld().getClazz());
        PerspectiveCompassFactory perspectiveCompassFactory = (new PerspectiveCompassFactoryInitialiser(config)).map(config.getCompassFactory().getClazz());
        PerspectiveFactory perspectiveFactory = (new PerspectiveFactoryInitialiser(perspectiveCompassFactory)).map(config.getReaPerspectiveFactory().getClazz());
        PhysicalObjectFactory physicalObjectFactory = (new PhysicalObjectFactoryInitialiser(perspectiveFactory)).map(config.getReaPhysicalObjectFactory().getClazz());

        /* create initiators */
        globalInitiator = (new GlobalInitiatorInitialiser(config, world)).map(config.getReaGlobalInitiator().getClazz());
        worldInitiator = (new WorldInitiatorInitialiser(config, world, physicalObjectFactory)).map(config.getReaWorldInitiator().getClazz());
        localInitiator = (new LocalInitiatorInitialiser(config)).map(config.getReaLocalInitiator().getClazz());

        /* create clients */
        clients = new ArrayList<>();
        ClientInitialiser clientInitialiser = new ClientInitialiser();
        for (ToyRobot.ReaRobotClients.Client client : config.getReaRobotClients().getClient()) {
            clients.add(clientInitialiser.map((String) client.getClazz()));
        }
    }

    /**
     *
     * returns a list of clients
     *
     * @return
     */
    @Override
    public List<RobotClient> getClients() {
        return clients;
    }

    /**
     * sets the un marshaller
     *
     * @param reaUnMarshaller
     */
    @Override
    public void setReaUnMarshaller(ReaUnMarshaller reaUnMarshaller) {
        this.reaUnMarshaller = reaUnMarshaller;
    }

    /**
     * return the world initiator
     *
     * @return
     */
    @Override
    public WorldInitiator getWorldInitiator() {
        return worldInitiator;
    }

    /**
     * return the global initiator
     *
     * @return
     */
    @Override
    public GlobalInitiator getGlobalInitator() {
        return globalInitiator;
    }

    /**
     * return the local initiator
     *
     * @return
     */
    @Override
    public LocalInitiator getLocalInitiator() {
        return localInitiator;
    }
}
