package rea.toyrobot.config.mapper;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class TestRobotRectangleWorldConfig {

    private RobotRectangleWorldConfig robotRectagleWorldConfig = new RobotRectangleWorldConfig();

    @Test
    public void testRobotRectangleConfig() {
        robotRectagleWorldConfig.setLength(10);
        robotRectagleWorldConfig.setWidth(5);

        assertThat(robotRectagleWorldConfig.getLength(), is(10));
        assertThat(robotRectagleWorldConfig.getWidth(), is(5));
    }
}
