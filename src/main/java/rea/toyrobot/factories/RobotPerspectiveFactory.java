package rea.toyrobot.factories;

import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.perspective.RobotWorldPerspective;

/**
 * Creates the perspective for the robot.
 */

public interface RobotPerspectiveFactory {

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
    RobotWorldPerspective create() throws RobotInitialisationException;
}
