package rea.toyrobot.client;

import rea.toyrobot.executor.RobotService;
import rea.toyrobot.responder.ReaRobotResponder;
import rea.toyrobot.responder.RobotResponder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class RobotCMDClient implements RobotClient {
    private RobotService robotService;

    @Override
    public void setRobotService(RobotService robotService) {
        this.robotService = robotService;
    }

    @Override
    public void run() {
        Reader inp = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inp);
        boolean isExit = false;

        try {
            while (!isExit) {

                RobotResponder robotResponder = new ReaRobotResponder();
                robotService.setRobotResponder(robotResponder);
                robotService.execute(br.readLine().split("\\s+"));

                if (robotResponder.hasResponse()) {
                    System.out.println(robotResponder.getResponse());
                }

                if (robotResponder.terminateClient()) {
                    isExit = true;
                }
            }
        }
        catch (Exception e) {
            System.out.println("FATAL ERROR: - " + e.getMessage());
            return;
        }
    }
}
