package rea.toyrobot.executor;

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
    void execute(String[] cmd);

    boolean verifyAction(String[] cmd);

    void setRobotResponder(RobotResponder robotResponder);

    RobotResponder getRobotResponder();
}
