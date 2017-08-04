package rea.toyrobot.executor;

import org.junit.Before;
import org.junit.Test;
import rea.toyrobot.actions.physicalobjects.GlobalAction;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.worlds.World;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestGlobalInitator {
    private GlobalInitiator globalInitiator = new GlobalInitiator();
    private World world = mock(World.class);
    private PhysicalObject physicalObject = mock(PhysicalObject.class);

    @Before
    public void init() {
        globalInitiator.setPhysicalObject(physicalObject);
        globalInitiator.setWorld(world);
        clearInvocations();
    }

    @Test
    public void testRunAction1() throws Exception {
        GlobalAction action1 = mock(GlobalAction.class);
        GlobalAction action2 = mock(GlobalAction.class);

        when(action1.canPerformAction(any())).thenReturn(true);
        when(action2.canPerformAction(any())).thenReturn(false);

        globalInitiator.addAction(action1);
        globalInitiator.addAction(action2);

        globalInitiator.execute(new String[] {"TEST"});

        verify(action1).setWorld(world);
        verify(action1).setPhysicalObject(physicalObject);
        verify(action1).runAction();
    }

    public void testRunAction2() throws Exception {
        GlobalAction action1 = mock(GlobalAction.class);
        GlobalAction action2 = mock(GlobalAction.class);

        when(action1.canPerformAction(any())).thenReturn(false);
        when(action2.canPerformAction(any())).thenReturn(true);

        globalInitiator.addAction(action1);
        globalInitiator.addAction(action2);

        globalInitiator.execute(new String[] {"TEST"});

        verify(action2).setWorld(world);
        verify(action2).setPhysicalObject(physicalObject);
        verify(action2).runAction();
    }

}
