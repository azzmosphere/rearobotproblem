package rea.toyrobot.exceptions;

public class RobotInitialisationException extends RobotException {
    public RobotInitialisationException(String message) {
        super("unable to initialise object " + message);
    }
}
