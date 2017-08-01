package rea.toyrobot.perspective;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class TestPerspectiveCompass {

    EnumPerspectiveCompass perspectiveCompass;

    @Before
    public void setupTest() {
        perspectiveCompass = EnumPerspectiveCompass.NORTH;
    }

    @Test
    public void testRetrieveInitialPerspective() {
        assertThat(perspectiveCompass.getCardinalDirection("SOUTH"), is(EnumPerspectiveCompass.SOUTH));
    }

    @Test
    public void testRotateClockwise() {
        assertThat(perspectiveCompass.rotateClockwise(), is(EnumPerspectiveCompass.EAST));
    }

    @Test
    public void testRotateAntiClockwise() {
        assertThat(perspectiveCompass.rotateAntiClockwise(), is(EnumPerspectiveCompass.WEST));
    }
}
