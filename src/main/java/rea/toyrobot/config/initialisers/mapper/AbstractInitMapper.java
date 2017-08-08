package rea.toyrobot.config.initialisers.mapper;

import rea.toyrobot.exceptions.RobotInitialisationException;

public abstract class AbstractInitMapper<I> {
    public abstract void configure(I instance) throws RobotInitialisationException;

    public I map(String clazz) throws RobotInitialisationException {
        I object;

        try {
            Class c = Class.forName(clazz);
            object  = (I) c.newInstance();
            configure(object);
        }
        catch (ClassNotFoundException e) {
            throw new RobotInitialisationException("unable to find class " + clazz + " " + e.getMessage());
        }
        catch (IllegalAccessException e) {
            throw new RobotInitialisationException("illegaAccessException thrown while trying to load class " + e.getMessage());
        }
        catch (InstantiationException e) {
            throw new RobotInitialisationException("InstantiationException exception was thrown " + e.getMessage());
        }

        return object;
    }
}
