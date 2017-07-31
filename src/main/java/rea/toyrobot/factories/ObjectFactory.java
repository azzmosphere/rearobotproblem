package rea.toyrobot.factories;

/**
 * When given a class the object factory creates a instance of that object
 * assigning it to the base interface that it needs to be.
 */

public class ObjectFactory<I, C> {
    protected I createObject(Class<C> clazz) {
        return null;
    }
}
