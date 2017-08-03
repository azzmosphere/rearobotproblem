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

        perspective.setCompass(perspectiveCompass);
    }

    @Test
    public void testRunActionNorth() throws Exception {
        when(perspectiveCompass.getCardinalDirection()).thenReturn("NORTH");
        moveAction.runAction();
        verify(perspective).setYPos(yarg.capture());
        verify(world).setObject(xargWorld.capture(), yargWorld.capture());
        assertThat(yarg.getValue(), is(2));
        assertThat(xargWorld.getValue(), is(0));
        assertThat(yargWorld.getValue(), is(1));
    }
}
