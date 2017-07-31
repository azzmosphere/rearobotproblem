package rea.toyrobot.worlds;

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
    void setObject(int x, int y);

    /**
     * remove object from position x,y
     *
     * @param x
     * @param y
     */
    void removeObject(int x, int y);
}
