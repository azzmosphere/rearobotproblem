package rea.toyrobot.physicalobjects;

/**
 * Toy Robot is a physical object that can reside
 * in the table top world.
 */

import rea.toyrobot.perspective.Perspective;

public class ToyRobot implements PhysicalObject{
    @Override
    public Perspective getPerspective() {
        return null;
    }

    @Override
    public void setPerspective(Perspective perspective) {

    }

    @Override
    public void setGetType(String objectType) {

    }

    @Override
    public String getType() {
        return null;
    }
}
