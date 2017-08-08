package rea.toyrobot.perspective;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

public class TestRobotPerspectiveFactory {
    private PerspectiveFactory perspectiveFactory = new RobotPerspectiveFactory();
    private PerspectiveCompassFactory compassFactory = mock(PerspectiveCompassFactory.class);
    private PerspectiveCompass compass = mock(PerspectiveCompass.class);

    @Before
    public void init() throws Exception {
        when(compassFactory.create()).thenReturn(compass);
        perspectiveFactory.setCompassFactory(compassFactory);
    }

    @Test
    public void testCreate() throws Exception {
        Perspective perspective = perspectiveFactory.create();
        assertThat(perspective, instanceOf(Perspective.class));
        assertThat(perspective, instanceOf(RobotPerspective.class));
    }
}
