package rea.toyrobot.executor;

import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.responder.RobotResponder;

/**
 *  This service is used by the public interfaces
 */

public class RobotServiceImpl implements RobotService {
    private WorldInitiator worldInitiator;
    private GlobalInitiator globalInitiator;
    private LocalInitiator localInitiator;
    private RobotResponder robotResponder;
    private PhysicalObject physicalObject;

    @Override
    public  void setWorldInitiator(WorldInitiator worldInitiator) {
        this.worldInitiator = worldInitiator;
    }

    @Override
    public void setGlobalInitiator(GlobalInitiator globalInitiator) {
        this.globalInitiator = globalInitiator;
    }

    @Override
    public  void setLocalInitiator(LocalInitiator localInitiator) {
        this.localInitiator = localInitiator;
    }

    @Override
    public synchronized  void execute(String[] cmd) {
        try {
            worldInitiator.setRobotResponder(robotResponder);
            worldInitiator.setPhysicalObject(physicalObject);
            worldInitiator.execute(cmd);

            if (robotResponder.hasResponse() && worldInitiator.getPhysicalObject() != null) {
                physicalObject = worldInitiator.getPhysicalObject();
            } else if (!robotResponder.hasResponse()) {
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
        catch (Exception e) {
            robotResponder.setHasResponse(true);
            robotResponder.setResponse("ERROR: could not perform command " + e.getMessage());
        }
    }

    @Override
    public void setRobotResponder(RobotResponder robotResponder) {
        this.robotResponder = robotResponder;
    }

    @Override
    public RobotResponder getRobotResponder() {
        return robotResponder;
    }

}
