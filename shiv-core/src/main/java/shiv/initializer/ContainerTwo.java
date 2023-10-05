package shiv.initializer;

import shiv.flexible.Initializer;

import java.util.Objects;

public final class ContainerTwo<T,A,B> implements InitializerContainer {

    final Class<T> t;
    final Class<A> a;
    final Class<B> b;
    final Initializer.Two<T,A,B> two;

    public ContainerTwo(Class<T> t, Class<A> a, Class<B> b, Initializer.Two<T, A, B> two) {
        this.t = t;
        this.a = a;
        this.b = b;
        this.two = two;
    }

    @Override
    public Object produce(Object[] objects) {
        Object uncastedA = Objects.requireNonNull(objects[0]);
        Object uncastedB = Objects.requireNonNull(objects[1]);

        return two.provide(
                a.cast(uncastedA),
                b.cast(uncastedB)
        );
    }

    @Override
    public Class<?>[] dependencies() {
        return new Class[] {a,b};
    }

    @Override
    public Class<?> provides() {
        return t;
    }
}