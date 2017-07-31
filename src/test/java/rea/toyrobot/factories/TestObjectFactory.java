package rea.toyrobot.factories;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

public class TestObjectFactory {

    private ObjectFactory<TestClassI, TestClassC> objectFactory = new ObjectFactory<>(TestClassC.class);

    @Test
    public void testGenerateObject() throws Exception {
        TestClassI concrete = objectFactory.create();

        assertThat(concrete, instanceOf(TestClassC.class));

    }
}
