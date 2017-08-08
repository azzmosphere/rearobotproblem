package rea.toyrobot.actions.world;

import org.junit.Before;
import org.junit.Test;
import rea.toyrobot.perspective.Perspective;
import rea.toyrobot.perspective.PerspectiveCompass;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.physicalobjects.PhysicalObjectFactory;
import rea.toyrobot.responder.RobotResponder;
import rea.toyrobot.worlds.World;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

public class TestPlaceAction {
    private WorldAction placeAction = new PlaceAction();
    private PhysicalObject robot = mock(PhysicalObject.class);
    private World tableTop = mock(World.class);
    private PhysicalObjectFactory factory = mock(PhysicalObjectFactory.class);
    private Perspective perspective = mock(Perspective.class);
    private PerspectiveCompass perspectiveCompass = mock(PerspectiveCompass.class);
    private RobotResponder responder = mock(RobotResponder.class);

    @Before
    public void init() throws Exception {
        placeAction.setWorld(tableTop);
        placeAction.setPhysicalObjectFactory(factory);
        placeAction.setResponse(responder);

        when(factory.create()).thenReturn(robot);
        when(robot.getPerspective()).thenReturn(perspective);
        when(perspective.getCompass()).thenReturn(perspectiveCompass);
        when(perspectiveCompass.findCardinalDirection("NORTH")).thenReturn(perspectiveCompass);
    }

    @Test
    public void testCanPerformAction() {
        assertThat(placeAction.canPerformAction(new String[] {"PLACE", "0,0,NORTH"}), is(true));
        assertThat(placeAction.canPerformAction(new String[] {"LEFT"}), is(false));
    }

    @Test
    public void testRunAction() throws Exception {
        doNothing().when(tableTop).setObject(0, 0);
        doNothing().when(perspective).setXPos(0);
        doNothing().when(perspective).setYPos(0);
        when(tableTop.canMoveTo(0, 0)).thenReturn(true);

        placeAction.setArgsIn(new String[] {"PLACE", "0,0,NORTH"});
        PhysicalObject object = placeAction.runAction();

        assertThat(object, is(robot));
    }

}
