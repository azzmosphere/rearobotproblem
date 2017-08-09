package rea.toyrobot.physicalobjects;

/**
 * implementation of the Toy Robot factory.
 */

import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.factories.ReaObjectFactory;
import rea.toyrobot.perspective.PerspectiveFactory;

public class ToyRobotFactory extends ReaObjectFactory<PhysicalObject, ToyRobot> implements PhysicalObjectFactory {
    PerspectiveFactory perspectiveFactory;

    @Override
    public void setPerspectiveFactory(PerspectiveFactory perspectiveFactory) {
        this.perspectiveFactory = perspectiveFactory;
    }

    public ToyRobotFactory() {
        super(ToyRobot.class);
    }

    @Override
    protected final ToyRobot init(ToyRobot object) throws RobotInitialisationException {

        try {
            object.setPerspective(perspectiveFactory.create());
        }
        catch (RobotInitialisationException e) {
            throw e;
        }
        catch (Exception e) {
            throw new RobotInitialisationException("a unchecked error has occurred " + e.getMessage());
        }

        return object;
    }
}
