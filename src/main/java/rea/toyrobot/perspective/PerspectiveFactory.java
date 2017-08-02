package rea.toyrobot.perspective;

import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.factories.RobotCompassFactory;

/**
 * Creates the perspective for the robot.
 */

public interface PerspectiveFactory {

    /**
     * compass factory to use with perspective
     *
     * @param compassFactory
     */
    /*
     * The factory is used here so that the perspective has a unique compass
     * for its perspective.
     */
    void setCompassFactory(RobotCompassFactory compassFactory);

    /**
     * creation class
     *
     * @return
     * @throws RobotInitialisationException
     */
    Perspective create() throws RobotInitialisationException;
}
