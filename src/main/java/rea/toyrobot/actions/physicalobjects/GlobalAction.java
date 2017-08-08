package rea.toyrobot.actions.physicalobjects;

/**
 * changes the worlds perspective of a physical object.
 */

import rea.toyrobot.worlds.World;

public interface GlobalAction extends LocalAction {
    /**
     * sets the world that is to be modified.
     *
     * @param world
     */
    void setWorld(World world);
}
