package rea.toyrobot.physicalobjects;

/**
 * interface for physical objects
 */

import rea.toyrobot.perspective.Perspective;

public interface PhysicalObject {
    /**
     * returns the objects perspective
     *
     * @return
     */
    Perspective getPerspective();

    /**
     * sets the objects perspective.
     *
     * @param perspective
     */
    void setPerspective(Perspective perspective);

    /**
     * returns a type identifying the physical object.
     *
     * @return
     */
    String getType();
}
