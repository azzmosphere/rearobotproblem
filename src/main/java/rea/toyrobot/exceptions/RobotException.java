package rea.toyrobot.exceptions;

/**
 * general exception, base class for all other exception
 */

public class RobotException extends Exception {
    public RobotException(String message) {
        super(message);
    }
}
