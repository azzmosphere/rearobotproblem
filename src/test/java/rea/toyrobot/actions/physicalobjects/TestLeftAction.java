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

public class TestLeftAction {
    private LocalAction leftAction = new LeftAction();
    private PhysicalObject robot = mock(PhysicalObject.class);
    private Perspective perspective = mock(Perspective.class);
    private PerspectiveCompass compass = mock(PerspectiveCompass.class);

    @Before
    public void init() throws Exception {
        when(robot.getPerspective()).thenReturn(perspective);
        when(perspective.getCompass()).thenReturn(compass);
        when(compass.rotateAntiClockwise()).thenReturn(compass);
        leftAction.setPhysicalObject(robot);
    }
    @Test
    public void testMoveLeft() throws Exception {
        leftAction.runAction();
        verify(compass, atLeastOnce()).rotateAntiClockwise();
        verify(compass, atMost(1)).rotateAntiClockwise();
        verify(perspective, atLeastOnce()).setCompass(compass);
    }

}
