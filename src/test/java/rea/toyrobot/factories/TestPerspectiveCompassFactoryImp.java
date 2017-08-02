package rea.toyrobot.factories;

import org.junit.Before;
import org.junit.Test;
import rea.toyrobot.config.mapper.RobotCompassConfig;
import rea.toyrobot.perspective.PerspectiveCompassFactoryImp;
import rea.toyrobot.perspective.PerspectiveCompass;
import rea.toyrobot.perspective.PerspectiveCompassFactory;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

public class TestPerspectiveCompassFactoryImp {
    private RobotCompassConfig mapper = mock(RobotCompassConfig.class);
    private PerspectiveCompassFactory perspectiveCompassFactory = new PerspectiveCompassFactoryImp();

    @Before
    public void init() {
        when(mapper.getInitialpos()).thenReturn("NORTH");
        perspectiveCompassFactory.setObjectMapper(mapper);
    }

    @Test
    public void testObject() throws Exception {
        assertThat(perspectiveCompassFactory.create(), instanceOf(PerspectiveCompass.class));
    }

    @Test
    public void testObjectIsInitialised() throws Exception {
        PerspectiveCompass compass = perspectiveCompassFactory.create();
        assertThat(compass.getCardinalDirection(), is("NORTH"));
    }

}
