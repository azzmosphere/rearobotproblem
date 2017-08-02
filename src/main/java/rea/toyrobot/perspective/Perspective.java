package rea.toyrobot.perspective;

/**
 * represents the view of the world from the robots perspective
 *
 */

public interface Perspective {

    /**
     * returns the current X position
     * @return
     */
    int getXPos();

    /**
     * sets the currnet X position
     *
     * @param x
     */
    void setXPos(int x);

    /**
     * return the y position
     * @return
     */
    int getYpos();

    /**
     * set the current Y position.
     *
     * @param y
     */
    void setYPos(int y);

    /**
     * return the current direction that robot is facing.
     * @return
     */
    PerspectiveCompass getCompass();

    /**
     * set the direction that the compass is facing.
     * @param compass
     */
    void setCompass(PerspectiveCompass compass);
}
