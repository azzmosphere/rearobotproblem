package rea.toyrobot.executor;

import org.junit.Before;
import org.junit.Test;
import rea.toyrobot.physicalobjects.PhysicalObject;
import rea.toyrobot.responder.RobotResponder;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;

public class TestRobotService {
    private RobotService robotService = new RobotService();
    private GlobalInitiator globalInitiator = mock(GlobalInitiator.class);
    private LocalInitiator localInitiator = mock(LocalInitiator.class);
    private WorldInitiator worldInitiator = mock(WorldInitiator.class);
    private RobotResponder robotResponder = mock(RobotResponder.class);
    private PhysicalObject physicalObject = mock(PhysicalObject.class);

    @Before
    public void init() {
        clearInvocations();
        robotService.setGlobalInitiator(globalInitiator);
        robotService.setLocalInitiator(localInitiator);
        robotService.setWorldInitiator(worldInitiator);
        robotService.setRobotResponder(robotResponder);
    }

    @Test
    public void testWorldInitiator() throws Exception {
        String[] cmd = new String[] {"TEST"};
        when(worldInitiator.getPhysicalObject()).thenReturn(physicalObject);
        when(robotResponder.hasResponse()).thenReturn(true);
        robotService.execute(cmd);

        verify(globalInitiator, never()).execute(cmd);
        verify(localInitiator, never()).execute(cmd);
        verify(worldInitiator, atLeastOnce()).execute(cmd);
        verify(worldInitiator, atMost(1)).execute(cmd);
    }

    @Test
    public void testGlobalInitiator() throws Exception {
        String[] cmd = new String[] {"TEST"};
        when(worldInitiator.getRobotResponder()).thenReturn(robotResponder);
        when(worldInitiator.getPhysicalObject()).thenReturn(physicalObject);
        when(robotResponder.hasResponse()).thenReturn(false);

        RobotResponder globalResponder = mock(RobotResponder.class);
        when(globalResponder.hasResponse()).thenReturn(true);
        when(globalInitiator.getRobotResponder()).thenReturn(globalResponder);

        robotService.execute(cmd);
        verify(localInitiator, never()).execute(cmd);
        verify(globalInitiator, atLeastOnce()).execute(cmd);
        verify(globalInitiator, atMost(1)).execute(cmd);
    }

    @Test
    public void testLocalInitiator() throws Exception {
        String[] cmd = new String[] {"TEST"};
        when(worldInitiator.getRobotResponder()).thenReturn(robotResponder);
        when(worldInitiator.getPhysicalObject()).thenReturn(physicalObject);
        when(robotResponder.hasResponse()).thenReturn(false);

        RobotResponder globalResponder = mock(RobotResponder.class);
        when(globalResponder.hasResponse()).thenReturn(false);
        when(globalInitiator.getRobotResponder()).thenReturn(globalResponder);

        RobotResponder localResponder = mock(RobotResponder.class);
        when(localResponder.hasResponse()).thenReturn(true);

        robotService.execute(cmd);

        verify(localInitiator, atLeastOnce()).execute(cmd);
        verify(localInitiator, atMost(1)).execute(cmd);
    }

}
