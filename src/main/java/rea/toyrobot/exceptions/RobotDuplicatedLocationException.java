package rea.toyrobot.exceptions;

/**
 * object exists in another location
 */

public class RobotDuplicatedLocationException extends RobotException {
    public RobotDuplicatedLocationException(String message) {
        super("object already exists in this location " + message);
    }
}
