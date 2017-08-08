package rea.toyrobot.exceptions;

/**
 * object does not exist
 */

public class RobotDoesNotExistException  extends RobotException {
    public RobotDoesNotExistException(String message) {
        super("no pysical object can be found " + message);
    }
}
