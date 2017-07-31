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

public abstract class ObjectFactory<I, C extends I> {

    private  Class<C> concreteClass;
    private I instance;

    public  ObjectFactory(Class<C> concreteClass) {
        this.concreteClass = concreteClass;
    }

    /**
     * perform any initialisation that the newly created object needs
     *
     * @param object
     * @return
     */
    protected  abstract C init(C object);

    /**
     *
     * @return a blank instance of a given object.
     */
    protected I create() throws InstantiationException, IllegalAccessException {

        if (instance == null) {
            instance = init(concreteClass.newInstance());
        }
        return instance;
    }
}
