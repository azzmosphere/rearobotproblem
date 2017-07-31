package rea.toyrobot.exceptions;

public class RobotDuplicatedLocationException extends RobotException {
    public RobotDuplicatedLocationException(String message) {
        super("object already exists in this location " + message);
    }
}
