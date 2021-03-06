package rea.toyrobot.executor;

import org.junit.Before;
import org.junit.Test;
import rea.toyrobot.actions.world.WorldAction;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.responder.RobotResponder;
import rea.toyrobot.worlds.World;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;


public class TestWorldInitiator {
    private WorldInitiatorImpl worldInitiator = new WorldInitiatorImpl();

    private PhysicalObject physicalObject = mock(PhysicalObject.class);
    private World world = mock(World.class);
    private WorldAction action1 = mock(WorldAction.class);
    private WorldAction action2 = mock(WorldAction.class);
    private RobotResponder responder = mock(RobotResponder.class);

    @Before
    public void init() throws Exception {
        clearInvocations();
        worldInitiator.setWorld(world);
        worldInitiator.setRobotResponder(responder);
        when(action1.runAction()).thenReturn(physicalObject);
        when(action2.runAction()).thenReturn(physicalObject);
    }

    @Test
    public void testExecuteAction1() throws Exception {

        // only the first action should be performed.
        when(action1.canPerformAction(any())).thenReturn(true);
        when(action2.canPerformAction(any())).thenReturn(true);

        worldInitiator.addAction(action1);
        worldInitiator.addAction(action2);

        worldInitiator.execute(new String[] {"TEST"});

        PhysicalObject object = worldInitiator.getPhysicalObject();
        assertThat(object, is(physicalObject));

        verify(action1).runAction();
        verify(action2, never()).runAction();
        verify(responder).setHasResponse(true);
    }
}
