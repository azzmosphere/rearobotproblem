package rea.toyrobot.physicalobjects;

import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.perspective.PerspectiveFactory;

public class ToyRobotFactory implements PhysicalObjectFactory {
    @Override
    public void setPerspectiveFactory(PerspectiveFactory perspectiveFactory) {

    }

    @Override
    public PhysicalObject create() throws RobotInitialisationException {
        return null;
    }
}
