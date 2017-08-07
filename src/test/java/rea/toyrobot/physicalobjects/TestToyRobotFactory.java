package rea.toyrobot.physicalobjects;

import org.junit.Before;
import org.junit.Test;
import rea.toyrobot.perspective.Perspective;
import rea.toyrobot.perspective.PerspectiveFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestToyRobotFactory {
    private PerspectiveFactory perspectiveFactory = mock(PerspectiveFactory.class);
    private Perspective perspective = mock(Perspective.class);
    private ToyRobotFactory toyRobotFactory = new ToyRobotFactory();

    @Before
    public void init() throws Exception {
        toyRobotFactory.setPerspectiveFactory(perspectiveFactory);
        when(perspectiveFactory.create()).thenReturn(perspective);
    }

    @Test
    public void testPerspectiveFactory() throws Exception {
        PhysicalObject physicalObject = toyRobotFactory.create();
        assertThat(physicalObject, instanceOf(ToyRobot.class));
        assertThat(physicalObject, instanceOf(PhysicalObject.class));
        assertThat(physicalObject.getPerspective(), is(perspective));
    }

}
