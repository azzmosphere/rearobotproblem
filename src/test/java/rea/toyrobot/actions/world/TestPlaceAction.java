package rea.toyrobot.actions.world;

import org.junit.Before;
import org.junit.Test;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.physicalobjects.PhysicalObjectFactory;
import rea.toyrobot.worlds.World;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

public class TestPlaceAction {
    private WorldAction placeAction = new PlaceAction();
    private PhysicalObject robot = mock(PhysicalObject.class);
    private World tableTop = mock(World.class);
    private PhysicalObjectFactory factory = mock(PhysicalObjectFactory.class);

    @Before
    public void init() throws Exception {
        placeAction.setWorld(tableTop);
        placeAction.setPhysicalObjectFactory(factory);

        when(tableTop.canMoveTo(0, 0)).thenReturn(true);
        doNothing().when(tableTop).setObject(0, 0);
        when(factory.create()).thenReturn(robot);
    }

    @Test
    public void testCanPerformAction() {
        assertThat(placeAction.canPerformAction(new String[] {"PLACE", "0", "0", "NORTH"}), is(true));
        assertThat(placeAction.canPerformAction(new String[] {"LEFT"}), is(false));
    }

    @Test
    public void testRunAction() throws Exception {
        placeAction.setArgsIn(new String[] {"PLACE", "0", "0", "NORTH"});
        PhysicalObject object = placeAction.runAction();

        assertThat(object.getPerspective().getXPos(), is(0));
        assertThat(object.getPerspective().getYpos(), is(0));
        assertThat(object.getPerspective().getCompass().getCardinalDirection(), is("NORTH"));
        assertThat(tableTop.canMoveTo(0, 0), is(false));
    }

}
