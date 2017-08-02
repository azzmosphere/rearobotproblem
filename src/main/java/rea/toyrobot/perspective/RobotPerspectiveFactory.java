package rea.toyrobot.perspective;

/**
 * generates a RobotWorldPerspective
 */

import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.factories.ObjectFactory;
import rea.toyrobot.factories.RobotCompassFactory;

public class RobotPerspectiveFactory extends ObjectFactory<Perspective, RobotPerspective> implements PerspectiveFactory {
    public RobotPerspectiveFactory() {
        super(RobotPerspective.class);
    }

    @Override
    protected RobotPerspective init(RobotPerspective object) throws RobotInitialisationException {
        return null;
    }

    @Override
    public Perspective create() throws RobotInitialisationException {
        return super.create();
    }

    @Override
    public void setCompassFactory(RobotCompassFactory compassFactory) {

    }
}
