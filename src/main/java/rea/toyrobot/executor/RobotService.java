package rea.toyrobot.executor;

import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.responder.RobotResponder;

/**
 *  This service is used by the public interfaces
 */

public class RobotService {
    private WorldInitiator worldInitiator;
    private GlobalInitiator globalInitiator;
    private LocalInitiator localInitiator;
    private RobotResponder robotResponder;
    private PhysicalObject physicalObject;

    public  void setWorldInitiator(WorldInitiator worldInitiator) {
        this.worldInitiator = worldInitiator;
    }

    public void setGlobalInitiator(GlobalInitiator globalInitiator) {
        this.globalInitiator = globalInitiator;
    }

    public  void setLocalInitiator(LocalInitiator localInitiator) {
        this.localInitiator = localInitiator;
    }

    public synchronized  void execute(String[] cmd) {
        worldInitiator.setRobotResponder(robotResponder);
        worldInitiator.setPhysicalObject(physicalObject);
        worldInitiator.execute(cmd);

        if (robotResponder.hasResponse() && worldInitiator.getPhysicalObject() != null) {
            physicalObject = worldInitiator.getPhysicalObject();
        }
        else {
            globalInitiator.setPhysicalObject(physicalObject);
            globalInitiator.setRobotResponder(robotResponder);
            globalInitiator.execute(cmd);

            if (!globalInitiator.getRobotResponder().hasResponse()) {
                localInitiator.setRobotResponder(robotResponder);
                localInitiator.setCurrentObject(physicalObject);
                localInitiator.execute(cmd);
            }
        }
    }

    public void setRobotResponder(RobotResponder robotResponder) {
        this.robotResponder = robotResponder;
    }

    public RobotResponder getRobotResponder() {
        return robotResponder;
    }

}
