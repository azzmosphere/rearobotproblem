package rea.toyrobot.actions.physicalobjects;

import org.junit.Before;
import org.junit.Test;
import rea.toyrobot.perspective.Perspective;
import rea.toyrobot.perspective.PerspectiveCompass;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.responder.ReaRobotResponder;
import rea.toyrobot.responder.RobotResponder;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class TestReportAction {
    private LocalAction reportAction = new ReportAction();
    private PhysicalObject robot = mock(PhysicalObject.class);
    private Perspective perspective = mock(Perspective.class);
    private PerspectiveCompass compass = mock(PerspectiveCompass.class);
    private RobotResponder responder = new ReaRobotResponder();

    @Before
    public void init() throws Exception {
        when(robot.getPerspective()).thenReturn(perspective);
        when(perspective.getCompass()).thenReturn(compass);
        when(compass.getCardinalDirection()).thenReturn("NORTH");
        when(perspective.getXPos()).thenReturn(1);
        when(perspective.getYpos()).thenReturn(2);

        reportAction.setPhysicalObject(robot);
        reportAction.setResponse(responder);
    }

    @Test
    public void testReportAction() throws Exception {
        reportAction.runAction();
        assertThat(responder.hasResponse(), is(true));
        assertThat(responder.getResponse(), is("1,2,NORTH"));
    }

    @Test
    public void testCanPerformAction() throws Exception {
        assertThat(reportAction.canPerformAction(new String[] {"REPORT"}), is(true));
    }
}
