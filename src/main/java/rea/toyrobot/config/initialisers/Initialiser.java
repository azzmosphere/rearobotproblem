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
import java.util.List;

public interface Initialiser {
    void setSchema(String xmlschema);
    void setConfig(String xmlconfig);
    void initialise() throws RobotInitialisationException;
    List<RobotClient> getClients();
}
