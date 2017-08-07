package rea.toyrobot.responder;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class TestReaRobotResponder {
    private RobotResponder responder;

    @Before
    public void init() {
        responder = new ReaRobotResponder();
    }

    @Test
    public void testRobotResponderDefaults() {
        // should default to false.
        assertThat(responder.hasResponse(), is(false));
        assertThat(responder.getResponse(), nullValue());
    }

    /**
     * hasResponse can be true but getResponse can be null.
     */
    @Test
    public void testHasResponse() {
        responder.setHasResponse(true);

        assertThat(responder.hasResponse(), is(true));
        assertThat(responder.getResponse(), nullValue());
    }

    public void testHasResponseString() {
        responder.setHasResponse(true);
        responder.setResponse("hello world");

        assertThat(responder.hasResponse(), is(true));
        assertThat(responder.getResponse(), is("hello world"));
    }
}
