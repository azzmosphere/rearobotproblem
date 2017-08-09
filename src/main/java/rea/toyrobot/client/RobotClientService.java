package rea.toyrobot.client;

/**
 * registers and executes each child thread.
 */

import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.executor.RobotService;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RobotClientService {
    private Collection<RobotClient> clients;
    private RobotService robotService;

    /**
     * sets a list of clients
     *
     * @param clients
     */
    public void setClients(Collection<RobotClient> clients) {
        this.clients = clients;
    }

    /**
     * sets the robot service
     *
     * @param robotService
     */
    public void setRobotService(RobotService robotService) {
        this.robotService = robotService;
    }

    /**
     * creates a thread for each client and waits for them all to complete.
     *
     * @throws RobotException
     */
    public final void run() throws RobotException {
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(clients.size());
            for (RobotClient client : clients) {
                client.setRobotService(robotService);
            }

            List<Future<Boolean>> futures =  executorService.invokeAll(clients);

            for (Future<Boolean> f : futures) {
                if (!f.isDone()) {
                    System.out.println("at least one client has uncleanly");
                }
            }
        }
        catch (Exception e) {
            throw new RobotException("A unhandled exception has occurred this is bad" + e.getMessage());
        }
    }
}
