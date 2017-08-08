package rea.toyrobot.actions;

/**
 * base class for actions
 */

import rea.toyrobot.responder.RobotResponder;

public abstract class AbstractAction implements Action {
    protected RobotResponder responder;

    /**
     * set the response
     *
     * @param response
     */
    @Override
    public void setResponse(RobotResponder response) {
        this.responder = response;
    }

    /**
     *
     * return the response.
     *
     * @return
     */
    protected RobotResponder getResponder() {
        return responder;
    }
}
