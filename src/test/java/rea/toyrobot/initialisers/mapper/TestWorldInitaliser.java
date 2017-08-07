package rea.toyrobot.initialisers.mapper;

import org.junit.Before;
import org.junit.Test;
import rea.toyrobot.config.initialisers.mapper.WorldInitialiser;
import rea.toyrobot.config.mapper.jabx.ToyRobot;
import rea.toyrobot.worlds.World;
import rea.toyrobot.worlds.TableTopWorld;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class TestWorldInitaliser {
    private WorldInitialiser worldInitialiser;
    private ToyRobot config = mock(ToyRobot.class);
    private ToyRobot.World configw = mock(ToyRobot.World.class);

    @Before
    public void init() {
        worldInitialiser = new WorldInitialiser(config);
        when(config.getWorld()).thenReturn(configw);
        when(configw.getLength()).thenReturn(5);
        when(configw.getWidth()).thenReturn(5);
    }

    @Test
    public void testWorldInitialiser() throws Exception {
        World world = worldInitialiser.map("rea.toyrobot.worlds.TableTopWorld");
        assertThat(world, instanceOf(World.class));
        assertThat(world, instanceOf(TableTopWorld.class));
        assertThat(world.getLength(), is(5));
        assertThat(world.getWidth(), is(5));
    }
}
