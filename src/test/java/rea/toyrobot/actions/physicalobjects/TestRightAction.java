package rea.toyrobot.actions.physicalobjects;

import org.junit.Before;
import org.junit.Test;
import rea.toyrobot.perspective.Perspective;
import rea.toyrobot.perspective.PerspectiveCompass;
import rea.toyrobot.physicalobjects.PhysicalObject;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;

public class TestRightAction {
    private LocalAction RightActiong = new RightAction();
    private PhysicalObject robot = mock(PhysicalObject.class);
    private Perspective perspective = mock(Perspective.class);
    private PerspectiveCompass compass = mock(PerspectiveCompass.class);

    @Before
    public void init() throws Exception {
        when(robot.getPerspective()).thenReturn(perspective);
        when(perspective.getCompass()).thenReturn(compass);
        RightActiong.setPhysicalObject(robot);
    }
    @Test
    public void testMoveLeft() throws Exception {
        RightActiong.runAction();
        verify(compass, atLeastOnce()).rotateClockwise();
        verify(compass, atMost(1)).rotateClockwise();
    }

}
