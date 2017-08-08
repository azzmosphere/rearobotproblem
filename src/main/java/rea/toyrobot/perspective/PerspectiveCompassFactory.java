package rea.toyrobot.perspective;

/**
 * interface for compass factory
 */

import rea.toyrobot.factories.ReaObjectFactoryInterface;

public interface PerspectiveCompassFactory extends ReaObjectFactoryInterface<PerspectiveCompass> {
    /**
     * the initial position of the compass (cardinal direction)
     *
     * @param initialPosition
     */
    void setInitialPosition(String initialPosition);

    /**
     * returns the cardinal position.
     *
     * @return
     */
    String getInitialPosition();
}
