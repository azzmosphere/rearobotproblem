package rea.toyrobot.client;

import rea.toyrobot.executor.RobotService;

public class RobotCMDClient implements RobotClient {
    private RobotService robotService;

    @Override
    public void setRobotService(RobotService robotService) {
        this.robotService = robotService;
    }

    @Override
    public void run() {

    }
}
