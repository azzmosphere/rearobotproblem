package rea.toyrobot.factories;

import rea.toyrobot.exceptions.RobotInitialisationException;

/**
 * The object factory interface is used as a base class for
 * creating objects.
 *
 * @param <I>
 */

public interface ReaObjectFactoryInterface<I> {
    /**
     * returns a generic instance of the object.
     *
     * @return
     * @throws RobotInitialisationException
     */
    I create() throws RobotInitialisationException;
}
