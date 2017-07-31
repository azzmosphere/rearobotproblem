package rea.toyrobot.worlds;

import rea.toyrobot.exceptions.RobotDuplicatedLocationException;
import rea.toyrobot.exceptions.RobotInitialisationException;

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
    void setObject(int x, int y) throws RobotDuplicatedLocationException;

    /**
     * remove object from position x,y
     *
     * @param x
     * @param y
     */
    void removeObject(int x, int y);

    /**
     * initialises the robot interface, will throw an exception if a required
     * value does not exist.
     *
     * @param defaults
     * @throws RobotInitialisationException
     */
    void initialise(Map defaults) throws RobotInitialisationException;
}
