package rea.toyrobot.factories;

/**
 * generates a RobotWorldPerspective
 */

import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.perspective.RobotWorldPerspective;
import rea.toyrobot.perspective.RobotWorldView;

public class WorldViewFactory extends ObjectFactory<RobotWorldPerspective, RobotWorldView> implements RobotPerspectiveFactory{
    public WorldViewFactory() {
        super(RobotWorldView.class);
    }

    @Override
    protected RobotWorldView init(RobotWorldView object) throws RobotInitialisationException {
        return null;
    }

    @Override
    public RobotWorldPerspective create() throws RobotInitialisationException {
        return super.create();
    }

    @Override
    public void setCompassFactory(RobotCompassFactory compassFactory) {

    }
}
