package rea.toyrobot.physicalobjects;

/**
 * Toy Robot is a physical object that can reside
 * in the table top world.
 */

import rea.toyrobot.perspective.Perspective;

public class ToyRobot implements PhysicalObject {
    private static final String PO_TYPE = "ToyRobot";
    private Perspective perspective;

    @Override
    public Perspective getPerspective() {
        return perspective;
    }

    @Override
    public void setPerspective(Perspective perspective) {
        this.perspective = perspective;
    }

    @Override
    public String getType() {
        return PO_TYPE;
    }
}
