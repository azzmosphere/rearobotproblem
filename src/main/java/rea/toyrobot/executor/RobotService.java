package rea.toyrobot.executor;

import rea.toyrobot.responder.RobotResponder;

public interface RobotService {
    void setWorldInitiator(WorldInitiator worldInitiator);
    void setGlobalInitiator(GlobalInitiator globalInitiator);
    void setLocalInitiator(LocalInitiator localInitiator);
    void execute(String[] cmd);
    void setRobotResponder(RobotResponder robotResponder);
    RobotResponder getRobotResponder();
}
