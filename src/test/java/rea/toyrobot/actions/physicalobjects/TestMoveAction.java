package rea.toyrobot.actions.physicalobjects;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import rea.toyrobot.perspective.Perspective;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.worlds.World;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestMoveAction {
    private GlobalAction moveAction = new MoveAction();
    private ArgumentCaptor<Integer> yarg = ArgumentCaptor.forClass(Integer.class);
    private PhysicalObject physicalObjectMock = mock(PhysicalObject.class);
    private Perspective perspective = mock(Perspective.class);
    private World world = mock(World.class);

    @Before
    public void init() {
        moveAction.setPhysicalObject(physicalObjectMock);
        moveAction.setWorld(world);
        when(physicalObjectMock.getPerspective()).thenReturn(perspective);
    }

    @Test
    public void testRunActionNorth() throws Exception {
        when(perspective.getCompass().getCardinalDirection()).thenReturn("NORTH");

        moveAction.runAction();

        verify(perspective).setYPos(yarg.capture());
    }
}
