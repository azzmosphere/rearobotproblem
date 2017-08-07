package rea.toyrobot.physicalobjects;

import org.junit.Test;
import rea.toyrobot.perspective.Perspective;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;

public class TestToyRobot {
    @Test
    public void testToyRobot() {
        PhysicalObject toyRobot = new ToyRobot();
        Perspective perspective = mock(Perspective.class);

        toyRobot.setPerspective(perspective);

        assertThat(toyRobot, instanceOf(PhysicalObject.class));
        assertThat(toyRobot.getPerspective(), is(perspective));
        assertThat(toyRobot.getType(), is("ToyRobot"));
    }
}
