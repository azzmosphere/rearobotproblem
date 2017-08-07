package rea.toyrobot.factories;

import rea.toyrobot.exceptions.RobotInitialisationException;

/**
 * The object factory interface is used as a base class for
 * creating objects.
 *
 * @param <I>
 */

public interface ReaObjectFactoryInterface<I> {
    I create() throws RobotInitialisationException;
}
