package rea.toyrobot.client;

/**
 * registers and executes each child thread.
 */

import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.executor.RobotService;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RobotClientService {
    private List<RobotClient> clients;
    private RobotService robotService;

    /**
     * sets a list of clients
     *
     * @param clients
     */
    public void setClients(List<RobotClient> clients) {
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
    public void run() throws RobotException {
        ExecutorService[] executorServices = new ExecutorService[clients.size()];
        try {
            int i = 0;
            for (RobotClient client : clients) {
                client.setRobotService(robotService);
                ExecutorService executorService = Executors.newSingleThreadExecutor();
                executorService.execute(client);
                executorServices[i++] = executorService;

            }

            for (ExecutorService executorService : executorServices) {
                executorService.shutdown();
            }
        }
        catch (Exception e) {
            throw new RobotException("A unhandled exception has occurred this is bad" + e.getMessage());
        }
    }
}
