package rea.toyrobot.factories;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.CoreMatchers.not;

public class TestObjectFactory {

    private ReaObjectFactory<TestClassI, TestClassC> objectFactory = new ReaObjectFactory(TestClassC.class) {
        @Override
        protected Object init(Object object) {
            return object;
        }
    };

    @Test
    public void testGenerateObject() throws Exception {
        TestClassI concrete = objectFactory.create();

        assertThat(concrete, instanceOf(TestClassC.class));

    }

    @Test
    public void testInstance() throws Exception {
        TestClassI c1 = objectFactory.create(), c2 = objectFactory.create();

        assertThat(c1, not(c2));
    }
}
