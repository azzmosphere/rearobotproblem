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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class TestRightAction {
    private LocalAction rightAction = new RightAction();
    private PhysicalObject robot = mock(PhysicalObject.class);
    private Perspective perspective = mock(Perspective.class);
    private PerspectiveCompass compass = mock(PerspectiveCompass.class);

    @Before
    public void init() throws Exception {
        when(robot.getPerspective()).thenReturn(perspective);
        when(perspective.getCompass()).thenReturn(compass);
        when(compass.rotateClockwise()).thenReturn(compass);
        rightAction.setPhysicalObject(robot);
    }
    @Test
    public void testMoveLeft() throws Exception {
        rightAction.runAction();
        verify(compass, atLeastOnce()).rotateClockwise();
        verify(compass, atMost(1)).rotateClockwise();
        verify(perspective, atLeastOnce()).setCompass(compass);
    }

    @Test
    public void testCanPerformAction() {
        assertThat(rightAction.canPerformAction(new String[] {"LEFT"}), is(false));
        assertThat(rightAction.canPerformAction(new String[] {"RIGHT"}), is(true));
        assertThat(rightAction.canPerformAction(new String[] {"PLACE", "1,1,SOUTH"}), is(false));
    }
}
