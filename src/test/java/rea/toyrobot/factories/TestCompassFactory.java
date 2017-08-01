package rea.toyrobot.factories;

import org.junit.Before;
import org.junit.Test;
import rea.toyrobot.config.mapper.RobotCompassConfig;
import rea.toyrobot.perspective.PerspectiveCompass;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

public class TestCompassFactory {
    private RobotCompassConfig mapper = mock(RobotCompassConfig.class);
    private RobotCompassFactory robotCompassFactory = new CompassFactory();

    @Before
    public void init() {
        when(mapper.getInitialpos()).thenReturn("NORTH");
        robotCompassFactory.setObjectMapper(mapper);
    }

    @Test
    public void testObject() throws Exception {
        assertThat(robotCompassFactory.create(), instanceOf(PerspectiveCompass.class));
    }

    @Test
    public void testObjectIsInitialised() throws Exception {
        PerspectiveCompass compass = robotCompassFactory.create();
        assertThat(compass.getCardinalDirection(), is("NORTH"));
    }

}
