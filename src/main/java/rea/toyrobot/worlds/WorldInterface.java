package rea.toyrobot.worlds;

import rea.toyrobot.exceptions.RobotDuplicatedLocationException;
import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.exceptions.RobotOutOfBoundsException;
import rea.toyrobot.exceptions.RobotDoesNotExistException;

import java.util.Map;

/**
 * A world is a physical plane where a robot or other object can move about.
 *
 * The object must abide by the limits of the world.
 */

public interface WorldInterface {

    /**
     * check x and y coordinate to see if object can move there.
     *
     * @param x
     * @param y
     * @return true if allowed.
     */
    boolean canMoveTo(int x, int y);

    /**
     * Place object at position x,y
     *
     * @param x
     * @param y
     */
    void setObject(int x, int y) throws RobotDuplicatedLocationException, RobotOutOfBoundsException;

    /**
     * remove object from position x,y
     *
     * @param x
     * @param y
     */
    void removeObject(int x, int y);

    /**
     * moves a physical object from x,y to x2, y2.
     *
     * Will throw the following errors, and not complete task if:
     *    another physical object exists in x2, y2 will throw RobotDuplicatedLocationException
     *    x2,y2 is not part of the world will throw RobotOutOfBoundsException
     *    if there is no physical object in x,y will throw RobotDoesNotExistException
     *
     * @param x
     * @param y
     * @param x2
     * @param y2
     * @throws RobotDuplicatedLocationException
     * @throws RobotOutOfBoundsException
     * @throws RobotDoesNotExistException
     */
    void relocateObject(int x, int y, int x2, int y2) throws RobotDuplicatedLocationException, RobotOutOfBoundsException, RobotDoesNotExistException;

    /**
     * initialises the robot interface, will throw an exception if a required
     * value does not exist.
     *
     * @param defaults
     * @throws RobotInitialisationException
     */
    void initialise(Map defaults) throws RobotInitialisationException;
}
