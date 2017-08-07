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
    void initialise() throws RobotInitialisationException;
    List<RobotClient> getClients();
    void setReaUnMarshaller(ReaUnMarshaller reaUnMarshaller);
    WorldInitiator getWorldInitiator();
    GlobalInitiator getGlobalInitator();
    LocalInitiator getLocalInitiator();
}
