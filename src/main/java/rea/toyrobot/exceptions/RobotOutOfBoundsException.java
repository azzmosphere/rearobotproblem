package rea.toyrobot.exceptions;

public class RobotOutOfBoundsException extends RobotException {
    public RobotOutOfBoundsException(String message) {
        super("robot is out of bounds " + message);
    }
}
