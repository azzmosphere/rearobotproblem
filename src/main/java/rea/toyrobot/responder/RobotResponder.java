package rea.toyrobot.responder;

/**
 * The responder provides a interface for a action to respond back to the
 * client.
 */
public interface RobotResponder {
    boolean hasResponse();
    void setHasResponse(boolean hasResponse);
    String getResponse();
}
