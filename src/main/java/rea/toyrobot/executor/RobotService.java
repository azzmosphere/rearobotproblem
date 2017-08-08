package rea.toyrobot.executor;

/**
 * interface for the robot service
 */

import rea.toyrobot.responder.RobotResponder;

public interface RobotService {
    /**
     * sets the world initiator
     *
     * @param worldInitiator
     */
    void setWorldInitiator(WorldInitiator worldInitiator);

    /**
     * sets the global initiator
     *
     * @param globalInitiator
     */
    void setGlobalInitiator(GlobalInitiator globalInitiator);

    /**
     * sets the local initiator
     *
     * @param localInitiator
     */
    void setLocalInitiator(LocalInitiator localInitiator);

    /**
     * sends the command out to the listeners
     *
     * @param cmd
     */
    void execute(String[] cmd);

    /**
     * sets the responder
     *
     * @param robotResponder
     */
    void setRobotResponder(RobotResponder robotResponder);

    /**
     * returns the robot responder
     *
     * @return
     */
    RobotResponder getRobotResponder();
}
