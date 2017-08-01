package rea.toyrobot.config.mapper;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class TestCompassConfig {
    private RobotCompassConfig robotCompassConfig = new RobotCompassConfig();

    @Test
    public void testRobotCompassConfig() {
        robotCompassConfig.setInitialpos("NORTH");

        assertThat(robotCompassConfig.getInitialpos(), is("NORTH"));
    }
}
