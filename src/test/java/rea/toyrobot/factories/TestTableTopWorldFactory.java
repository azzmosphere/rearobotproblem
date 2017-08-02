package rea.toyrobot.factories;

import org.junit.Before;
import org.junit.Test;
import rea.toyrobot.config.mapper.RobotRectangleWorldConfig;
import rea.toyrobot.worlds.TableTopWorldFactoryImp;
import rea.toyrobot.worlds.World;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestTableTopWorldFactory {
    private TableTopWorldFactoryImp tableTopWorldFactoryImp = new TableTopWorldFactoryImp();
    private RobotRectangleWorldConfig robotRectangleWorldConfig =  mock(RobotRectangleWorldConfig.class);

    @Before
    public void init() throws Exception {
        when(robotRectangleWorldConfig.getLength()).thenReturn(5);
        when(robotRectangleWorldConfig.getWidth()).thenReturn(5);
        tableTopWorldFactoryImp.setObjectMapper(robotRectangleWorldConfig);
    }

    @Test
    public void testObject() throws Exception {
        assertThat(tableTopWorldFactoryImp.create(), instanceOf(World.class));
    }

    @Test
    public void testObjectIsInitialised() throws Exception {
        World world = tableTopWorldFactoryImp.create();
        world.setObject(0, 0);
        world.canMoveTo(1, 1);
    }
}
