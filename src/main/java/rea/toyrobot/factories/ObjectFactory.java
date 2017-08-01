package rea.toyrobot.factories;

import rea.toyrobot.exceptions.RobotInitialisationException;

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
    protected  abstract C init(C object) throws RobotInitialisationException;

    /**
     *
     * @return a blank instance of a given object.
     */
    public I create() throws RobotInitialisationException {

        try {
            if (instance == null) {
                instance = init(concreteClass.newInstance());
            }
        }
        catch (InstantiationException e) {
            throw new RobotInitialisationException("unable to instantiate new object " + e.getMessage());
        }
        catch (IllegalAccessException e) {
            throw new RobotInitialisationException("can not create object " + e.getMessage());
        }
        catch (Exception e) {
            throw new RobotInitialisationException("a unchecked exception has occurred " + e.getMessage());
        }
        return instance;
    }
}
