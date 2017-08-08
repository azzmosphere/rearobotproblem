package rea.toyrobot.executor;

import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.responder.RobotResponder;

public interface Initiator<A> {
    /**
     * Adds a specific action that can be added to the execution framework.
     * @param action
     */
    void addAction(A action);

    /**
     * execute the first listener that matches the action then exist.
     *
     * @param cmd
     */
    void execute(String[] cmd) throws RobotException;

    /**
     * used to check whether this command can be performed by the action.
     *
     * @param cmd
     * @return
     */
    boolean verifyAction(String[] cmd);

    /**
     * set the responder
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
