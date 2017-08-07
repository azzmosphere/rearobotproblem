package rea.toyrobot.perspective;

/**
 * generates a RobotWorldPerspective
 */

import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.factories.ReaObjectFactory;

public class RobotPerspectiveFactory extends ReaObjectFactory<Perspective, RobotPerspective> implements PerspectiveFactory {
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
    public void setCompassFactory(PerspectiveCompassFactory compassFactory) {

    }
}
