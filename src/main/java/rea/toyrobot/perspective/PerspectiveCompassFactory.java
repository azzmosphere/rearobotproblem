package rea.toyrobot.perspective;

import rea.toyrobot.factories.ReaObjectFactoryInterface;

public interface PerspectiveCompassFactory extends ReaObjectFactoryInterface<PerspectiveCompass> {
    void setInitialPosition(String initialPosition);
    String getInitialPosition();
}
