package rea.toyrobot.actions.physicalobjects;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import rea.toyrobot.perspective.Perspective;
import rea.toyrobot.perspective.PerspectiveCompass;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.worlds.World;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class TestMoveAction {
    private GlobalAction moveAction = new MoveAction();
    private ArgumentCaptor<Integer> yarg = ArgumentCaptor.forClass(Integer.class);
    private ArgumentCaptor<Integer> xargWorld = ArgumentCaptor.forClass(Integer.class);
    private ArgumentCaptor<Integer> yargWorld = ArgumentCaptor.forClass(Integer.class);
    private PhysicalObject physicalObjectMock = mock(PhysicalObject.class);
    private Perspective perspective = mock(Perspective.class);
    private World world = mock(World.class);
    private PerspectiveCompass perspectiveCompass = mock(PerspectiveCompass.class);

    @Before
    public void init() {
        moveAction.setPhysicalObject(physicalObjectMock);
        moveAction.setWorld(world);
        when(physicalObjectMock.getPerspective()).thenReturn(perspective);
        when(perspective.getXPos()).thenReturn(1);
        when(perspective.getYpos()).thenReturn(1);
        when(perspective.getCompass()).thenReturn(perspectiveCompass);
    }

    @Test
    public void testRunActionNorth() throws Exception {
        when(perspectiveCompass.getCardinalDirection()).thenReturn("NORTH");
        when(world.canMoveTo(1, 2)).thenReturn(true);
        moveAction.runAction();
        verify(perspective).setYPos(yarg.capture());
        verify(world).setObject(xargWorld.capture(), yargWorld.capture());
        assertThat(yarg.getValue(), is(2));
        assertThat(xargWorld.getValue(), is(1));
        assertThat(yargWorld.getValue(), is(2));
    }

    @Test
    public void testRunActionEast() throws Exception {
        when(perspectiveCompass.getCardinalDirection()).thenReturn("EAST");
        when(world.canMoveTo(2, 1)).thenReturn(true);
        moveAction.runAction();
        verify(perspective).setXPos(yarg.capture());
        verify(world).setObject(xargWorld.capture(), yargWorld.capture());
        assertThat(yarg.getValue(), is(2));
        assertThat(xargWorld.getValue(), is(2));
        assertThat(yargWorld.getValue(), is(1));
    }

    @Test
    public void testRunActionSouth() throws Exception {
        when(perspectiveCompass.getCardinalDirection()).thenReturn("SOUTH");
        when(world.canMoveTo(1, 0)).thenReturn(true);
        moveAction.runAction();
        verify(perspective).setYPos(yarg.capture());
        verify(world).setObject(xargWorld.capture(), yargWorld.capture());
        assertThat(yarg.getValue(), is(0));
        assertThat(xargWorld.getValue(), is(1));
        assertThat(yargWorld.getValue(), is(0));
    }

    @Test
    public void testRunActionWest() throws Exception {
        when(perspectiveCompass.getCardinalDirection()).thenReturn("WEST");
        when(world.canMoveTo(0, 1)).thenReturn(true);
        moveAction.runAction();
        verify(perspective).setXPos(yarg.capture());
        verify(world).setObject(xargWorld.capture(), yargWorld.capture());
        assertThat(yarg.getValue(), is(0));
        assertThat(xargWorld.getValue(), is(0));
        assertThat(yargWorld.getValue(), is(1));
    }
}
