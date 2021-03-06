package rea.toyrobot.executor;

import rea.toyrobot.actions.Action;
import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.responder.RobotResponder;

import java.util.ArrayList;
import java.util.List;

/**
 * Acts as a base class for actions that need to be executed.
 */

public abstract class AbstractInitiator<A extends Action> implements Initiator<A> {
    private final List<A> listeners = new ArrayList<>();
    private RobotResponder robotResponder;

    /**
     * Adds a specific action that can be added to the execution framework.
     * @param action
     */
    public final void addAction(A action) {
        listeners.add(action);
    }

    /**
     * perform any needed configuration work.
     *
     * @param action
     * @param cmd
     */
    protected abstract void configureAction(A action, String[] cmd);

    /**
     * execute the action, if needed capture the response.
     *
     * @param action
     * @throws RobotException
     */
    protected abstract void runAction(A action) throws RobotException;

    /**
     * execute the first listener that matches the action then exist.
     *
     * @param cmd
     * @throws RobotException
     */
    public final synchronized void execute(String[] cmd) {
        robotResponder.setHasResponse(false);
        robotResponder.setResponse(null);
        if (!verifyAction(cmd)) {
            robotResponder.setHasResponse(true);
            robotResponder.setResponse("action could not be verified");
            return;
        }

        try {
            for (A action : listeners) {
                if (action.canPerformAction(cmd)) {
                    configureAction(action, cmd);
                    action.setResponse(robotResponder);
                    runAction(action);
                    robotResponder.setHasResponse(true);
                    break;
                }
            }
        }
        catch (RobotException e) {
            robotResponder.setHasResponse(true);
            robotResponder.setResponse("could not process request " + e.getMessage());
        }
    }

    public void setRobotResponder(RobotResponder robotResponder) {
        this.robotResponder = robotResponder;
    }

    public RobotResponder getRobotResponder() {
        return robotResponder;
    }
}
