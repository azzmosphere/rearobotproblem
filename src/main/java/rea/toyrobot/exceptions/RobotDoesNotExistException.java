package rea.toyrobot.exceptions;

public class RobotDoesNotExistException  extends RobotException {
    public RobotDoesNotExistException(String message) {
        super("no pysical object can be found " + message);
    }
}
