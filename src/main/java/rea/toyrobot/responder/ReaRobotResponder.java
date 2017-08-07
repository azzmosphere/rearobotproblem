package rea.toyrobot.responder;

public class ReaRobotResponder implements RobotResponder {

    private boolean hasResponse;
    private String response;

    @Override
    public boolean hasResponse() {
        return hasResponse;
    }

    @Override
    public void setHasResponse(boolean hasResponse) {
        this.hasResponse = hasResponse;
    }

    @Override
    public String getResponse() {
        return response;
    }

    @Override
    public void setResponse(String response) {
        this.response = response;
    }
}
