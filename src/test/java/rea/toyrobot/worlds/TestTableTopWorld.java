package rea.toyrobot.worlds;

import org.junit.Before;
import org.junit.Test;
import rea.toyrobot.exceptions.RobotDoesNotExistException;
import rea.toyrobot.exceptions.RobotDuplicatedLocationException;
import rea.toyrobot.exceptions.RobotOutOfBoundsException;

import java.util.Map;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class TestTableTopWorld {
    private TableTopWorld tableTopWorld;

    @Before
    public void initWorld() throws Exception {
        Map<String, Integer> worldConfig = new HashMap<>();

        worldConfig.put("width", 5);
        worldConfig.put("length", 5);
        tableTopWorld = new TableTopWorld();
        tableTopWorld.initialise(worldConfig);
    }

    @Test
    public void testCanMoveTo() throws Exception {
        assertThat(tableTopWorld.canMoveTo(5, 5), is(false));
        assertThat(tableTopWorld.canMoveTo(0, 0), is(true));
    }

    @Test(expected = RobotDuplicatedLocationException.class)
    public void testSetObjectDuplicatedRobor() throws Exception {
        tableTopWorld.setObject(0, 0);
        tableTopWorld.setObject(0, 0);
    }

    @Test(expected = RobotOutOfBoundsException.class)
    public void testSetObjectOutOfBounds() throws Exception {
        tableTopWorld.setObject(5, 5);
    }

    /*
     * For this test we expect that a Duplication exception won't
     * be raised after we remove the object and re-add it.
     */
    @Test
    public void testRemoveObject() throws Exception {
        tableTopWorld.setObject(0, 0);
        tableTopWorld.removeObject(0, 0);
        tableTopWorld.setObject(0, 0);
    }

    @Test
    public void testRelocateObject1() throws Exception {
        tableTopWorld.setObject(0, 0);
        tableTopWorld.relocateObject(0, 0, 0, 1);
    }

    @Test(expected = RobotDuplicatedLocationException.class)
    public void testRelocateObjectDuplicateLoc() throws Exception {
        tableTopWorld.setObject(0, 0);
        tableTopWorld.relocateObject(0, 0, 0, 1);
        tableTopWorld.setObject(0, 0);
        tableTopWorld.relocateObject(0, 0, 0, 1);
    }

    @Test(expected = RobotOutOfBoundsException.class)
    public void testRelocateObjectOutOfBounds() throws Exception {
        tableTopWorld.setObject(0, 0);
        tableTopWorld.relocateObject(0, 0, 0, 5);
    }

    @Test(expected = RobotDoesNotExistException.class)
    public void testRelocateObjectRobotDoesExist() throws Exception {
        tableTopWorld.relocateObject(0, 0, 0, 1);
    }
}
