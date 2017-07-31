package rea.toyrobot.factories;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class TestObjectFactory {

    private interface of1Iface {
       void someMethod();
    }

    private class if1concrete implements of1Iface {
        @Override
        public void someMethod() {

        }
    }

    private ObjectFactory<of1Iface, if1concrete> objectFactory = new ObjectFactory() {};

    @Test
    public void testGenerateObject() throws Exception {
        of1Iface concrete = objectFactory.createObject(if1concrete.class);

        assertThat(concrete.getClass().toString(), is("if1concrete"));
    }
}
