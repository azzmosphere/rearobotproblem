package rea.toyrobot.perspective;

/**
 * A enumerated value that can be used to represent the direction that
 * the robot is facing, it forms part of the perspective.
 */
public interface PerspectiveCompass {


    /**
     * rotate the robot in a clockwise position 90 degrees
     * @return
     */
    PerspectiveCompass rotateClockwise();

    /**
     * rotate the robot in a anti clockwise position 90 degrees
     * @return
     */
    PerspectiveCompass rotateAntiClockwise();

    /**
     * Given a cardinal direction, such as "NORTH" return the perspectiveCompass
     * that matches that direction.
     *
     * @param cardinalDirection
     * @return
     */
    PerspectiveCompass findCardinalDirection(String cardinalDirection);

    /**
     * Return the current cardinal direction.
     *
     * @return
     */
    String getCardinalDirection();
}
