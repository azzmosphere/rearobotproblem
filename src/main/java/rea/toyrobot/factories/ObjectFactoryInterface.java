package rea.toyrobot.factories;

/**
 * The object factory interface is used as a base class for
 * creating objects.
 *
 * @param <I>
 */

public interface ObjectFactoryInterface<I, M> {
    I create();

    void setObjectMapper(M mapper);
}
