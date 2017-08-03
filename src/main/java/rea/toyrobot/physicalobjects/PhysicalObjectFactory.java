package rea.toyrobot.physicalobjects;

/**
 * physical objects represent a object that resides within a world.
 *
 * Every physical object has its own perspective of the world.
 */

import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.perspective.PerspectiveFactory;

public interface PhysicalObjectFactory  {

    /**
     * The perspective factory is used, to ensure that the physical objects
     * perspective of the world is unique.
     *
     * @param perspectiveFactory
     */
    void setPerspectiveFactory(PerspectiveFactory perspectiveFactory);

    /**
     * creates the physical object itself.
     *
     * @return
     * @throws RobotInitialisationException
     */
    PhysicalObject create() throws RobotInitialisationException;
}
