package rea.toyrobot.physicalobjects;

import rea.toyrobot.perspective.Perspective;

public interface PhysicalObject {
    Perspective getPerspective();

    void setPerspective(Perspective perspective);
}
