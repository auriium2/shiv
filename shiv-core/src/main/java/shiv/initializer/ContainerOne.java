package shiv.initializer;

import shiv.flexible.Initializer;

import java.util.Objects;

public final class ContainerOne<T,A> implements InitializerContainer {

    final Class<T> t;
    final Class<A> a;
    final Initializer.One<T,A> one;

    public ContainerOne(Class<T> t, Class<A> a, Initializer.One<T, A> one) {
        this.t = t;
        this.a = a;
        this.one = one;
    }

    @Override
    public Object produce(Object[] objects) {
        Object uncastedA = Objects.requireNonNull(objects[0]);

        return one.provide(
                a.cast(uncastedA)
        );
    }

    @Override
    public Class<?>[] dependencies() {
        return new Class[] { a };
    }

    @Override
    public Class<?> provides() {
        return t;
    }
}