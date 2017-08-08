package rea.toyrobot.config.initialisers;

/**
 * Initialises robot service and registers the clients to
 * that service.
 *
 * Once this is done the clients can be returned to the
 * main program so that execution can begin.
 */

import rea.toyrobot.client.RobotClient;
import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.executor.GlobalInitiator;
import rea.toyrobot.executor.LocalInitiator;
import rea.toyrobot.executor.WorldInitiator;

import java.util.List;

public interface Initialiser {
    /**
     * called to perform the initialisation of objects.
     *
     * @throws RobotInitialisationException
     */
    void initialise() throws RobotInitialisationException;

    /**
     *
     * list of clients (human interfaces)
     *
     * @return
     */
    List<RobotClient> getClients();

    /**
     *
     * un-marshall's the configuration
     *
     * @param reaUnMarshaller
     */
    void setReaUnMarshaller(ReaUnMarshaller reaUnMarshaller);

    /**
     * returns configured instance of the world initiator
     * @return
     */

    WorldInitiator getWorldInitiator();

    /**
     * returns a configured instance of the global initiator
     *
     * @return
     */
    GlobalInitiator getGlobalInitator();

    /**
     * returns a configured instance of the local initiator
     *
     * @return
     */
    LocalInitiator getLocalInitiator();
}
