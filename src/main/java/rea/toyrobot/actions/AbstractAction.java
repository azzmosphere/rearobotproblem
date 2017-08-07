package rea.toyrobot.actions;

import rea.toyrobot.responder.RobotResponder;

public abstract class AbstractAction implements Action {
    protected RobotResponder responder;

    @Override
    public void setResponse(RobotResponder response) {
        this.responder = response;
    }

    protected RobotResponder getResponder() {
        return responder;
    }
}
