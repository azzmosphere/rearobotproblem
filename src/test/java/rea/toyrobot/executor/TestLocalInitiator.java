package rea.toyrobot.executor;

import org.junit.Before;
import org.junit.Test;
import rea.toyrobot.actions.physicalobjects.LocalAction;
import rea.toyrobot.exceptions.RobotException;
import rea.toyrobot.physicalobjects.PhysicalObject;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TestLocalInitiator {
    LocalInitiator localInitiator = new LocalInitiator();
    LocalAction action1 = mock(LocalAction.class), action2 = mock(LocalAction.class);
    PhysicalObject physicalObject = mock(PhysicalObject.class);

    @Before
    public void init() {
        clearInvocations();
    }

    @Test
    public void testRunActionNoAction() throws RobotException {
        when(action1.canPerformAction(any())).thenReturn(false);
        when(action2.canPerformAction(any())).thenReturn(false);

        localInitiator.addAction(action1);
        localInitiator.addAction(action2);
        localInitiator.setCurrentObject(physicalObject);

        localInitiator.execute(new String[]{"TEST"});

        verify(action1, atLeastOnce()).canPerformAction(any());
        verify(action2, atLeastOnce()).canPerformAction(any());
        verify(action1, never()).runAction();
        verify(action2, never()).runAction();
    }

    @Test
    public void testRunActionAction2True() throws RobotException {

        when(action1.canPerformAction(any())).thenReturn(false);
        when(action2.canPerformAction(any())).thenReturn(true);

        localInitiator.addAction(action1);
        localInitiator.addAction(action2);
        localInitiator.setCurrentObject(physicalObject);

        localInitiator.execute(new String[]{"TEST"});

        verify(action1, atLeastOnce()).canPerformAction(any());
        verify(action2, atLeastOnce()).canPerformAction(any());
        verify(action1, never()).runAction();
        verify(action2, atLeastOnce()).runAction();
    }

    @Test
    public void testPhysicalObjectNotSet() throws RobotException {

        when(action1.canPerformAction(any())).thenReturn(false);
        when(action2.canPerformAction(any())).thenReturn(true);

        localInitiator.addAction(action1);
        localInitiator.addAction(action2);

        localInitiator.execute(new String[]{"TEST"});

        verify(action1, never()).canPerformAction(any());
        verify(action2, never()).canPerformAction(any());
        verify(action1, never()).runAction();
        verify(action2, never()).runAction();
    }

    @Test
    public void testRunActionAction1True() throws RobotException {
        when(action1.canPerformAction(any())).thenReturn(true);
        when(action2.canPerformAction(any())).thenReturn(false);

        localInitiator.addAction(action1);
        localInitiator.addAction(action2);
        localInitiator.setCurrentObject(physicalObject);

        localInitiator.execute(new String[]{"TEST"});

        verify(action1, atLeastOnce()).canPerformAction(any());
        verify(action2, never()).canPerformAction(any());
        verify(action1, atLeastOnce()).runAction();
        verify(action2, never()).runAction();
    }
}
