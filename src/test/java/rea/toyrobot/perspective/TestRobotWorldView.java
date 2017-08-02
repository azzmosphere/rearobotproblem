package rea.toyrobot.perspective;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class TestRobotWorldView {
    private Perspective perspective = new RobotPerspective();
    private PerspectiveCompass compass = mock(PerspectiveCompass.class);

    @Before
    public void init() {
        when(compass.getCardinalDirection()).thenReturn("SOUTH");
        perspective.setXPos(1);
        perspective.setYPos(3);
        perspective.setCompass(compass);
    }

    @Test
    public void testRobotWorldView() {
        assertThat(perspective.getXPos(), is(1));
        assertThat(perspective.getYpos(), is(3));
        assertThat(perspective.getCompass().getCardinalDirection(), is("SOUTH"));
    }
}
