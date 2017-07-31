package rea.toyrobot.factories;

/**
 * When given a class the object factory creates a instance of that object
 * assigning it to the base interface that it needs to be.
 *
 * The class should be sub classed by a concrete object factory that produces
 * something more concrete.
 *
 * The concrete implementations of this should looks something like
 *
 *  WorldObjectFactory<C> extends ObjectFactory<World, C extends World>
 *
 *  where World is a interface.
 */

public class ObjectFactory<I, C extends I> {

    Class<C> concreteClass;

    public  ObjectFactory(Class<C> concreteClass) {
        this.concreteClass = concreteClass;
    }

    /**
     *
     * @return a blank instance of a given object.
     */
    protected I create() throws InstantiationException, IllegalAccessException {

        I concrete = concreteClass.newInstance();
        return concrete;
    }
}
