package rea.toyrobot.client;

/**
 * checks for files in ROBOTCMDS and provides each line as commands to the robot client.
 */

import rea.toyrobot.executor.RobotService;
import rea.toyrobot.responder.ReaRobotResponder;
import rea.toyrobot.responder.RobotResponder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RobotFileClient implements RobotClient {
    private List<String> filesIn = new ArrayList<>();
    private RobotService robotService;
    private final String ROBOTCMDS = "ROBOTCMDS";

    @Override
    public void setRobotService(RobotService robotService) {
        this.robotService = robotService;
    }

    @Override
    public final Boolean call() {
        boolean isExit = false;
        while (!isExit) {
            RobotResponder robotResponder = new ReaRobotResponder();

            try {
                if (System.getenv(ROBOTCMDS) != null && !filesIn.contains(System.getenv(ROBOTCMDS))) {
                    filesIn.add(System.getenv(ROBOTCMDS));
                    BufferedReader br = new BufferedReader(new FileReader(System.getenv(ROBOTCMDS)));
                    String buf = br.readLine();

                    while (buf != null && buf.length() > 0) {
                        robotService.setRobotResponder(robotResponder);
                        robotService.execute(buf.split("\\s+"));

                        if (robotResponder.hasResponse() && robotResponder.getResponse() != null) {
                            System.out.println(robotResponder.getResponse());
                        }
                        buf = br.readLine();
                    }

                }
            }
            catch (IOException e) {
                System.out.println("ERROR: " + e.getMessage());
            }

            if (robotResponder.terminateClient()) {
                isExit = true;
            }
        }

        return true;
    }
}
