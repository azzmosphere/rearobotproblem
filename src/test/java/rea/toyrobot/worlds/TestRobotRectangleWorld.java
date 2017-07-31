package rea.toyrobot.worlds;

import org.junit.Test;
import java.util.Map;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class TestRobotRectangleWorld {
    private RobotRectangleWorld robotRectangleWorld = new RobotRectangleWorld();

    @Test
    public void testCanMoveTo() {
        Map<String, Integer> worldConfig = new HashMap<>();

        worldConfig.put("width", 5);
        worldConfig.put("length", 5);

        robotRectangleWorld.initialise(worldConfig);
        assertThat(robotRectangleWorld.canMoveTo(5, 5), is(false));
        assertThat(robotRectangleWorld.canMoveTo(0,0), is(true));
    }


}
