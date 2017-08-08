package rea.toyrobot.perspective;

/**
 * generates a RobotPerspective instance
 */

import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.factories.ReaObjectFactory;

public class RobotPerspectiveFactory extends ReaObjectFactory<Perspective, RobotPerspective> implements PerspectiveFactory {

    private PerspectiveCompassFactory compassFactory;

    public RobotPerspectiveFactory() {
        super(RobotPerspective.class);
    }

    @Override
    protected RobotPerspective init(RobotPerspective object) throws RobotInitialisationException {
        object.setCompass(compassFactory.create());
        return object;
    }

    @Override
    public void setCompassFactory(PerspectiveCompassFactory compassFactory) {
        this.compassFactory = compassFactory;
    }
}
