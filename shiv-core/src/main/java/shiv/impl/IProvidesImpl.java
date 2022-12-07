package shiv.impl;

import shiv.IProvides;
import shiv.IWith;

/**
 * fancy way of doing a builder that restricts nullity
 * @param <T> dont touch this
 */
class IProvidesImpl<T> implements IProvides<T> {

    final Class<T> providedClass;

    public IProvidesImpl(Class<T> providedClass) {
        this.providedClass = providedClass;
    }

    @Override
    public IWith.None<T> noDependencies() {
        return new WithImpl<>(providedClass, null, null, null, null, null);
    }

    @Override
    public <A> IWith.One<T, A> dependencies(Class<A> a) {
        return new WithImpl<>(providedClass, a, null, null, null, null);
    }

    @Override
    public <A, B> IWith.Two<T, A, B> dependencies(Class<A> a, Class<B> b) {
        return new WithImpl<>(providedClass, a, b, null, null, null);
    }

    @Override
    public <A, B, C> IWith.Three<T, A, B, C> dependencies(Class<A> a, Class<B> b, Class<C> c) {
        return new WithImpl<>(providedClass, a, b, c, null, null);
    }

    @Override
    public <A, B, C, D> IWith.Four<T, A, B, C, D> dependencies(Class<A> a, Class<B> b, Class<C> c, Class<D> d) {
        return new WithImpl<>(providedClass, a, b, c, d, null);
    }

    @Override
    public <A, B, C, D, E> IWith.Five<T, A, B, C, D, E> dependencies(Class<A> a, Class<B> b, Class<C> c, Class<D> d, Class<E> e) {
        return new WithImpl<>(providedClass, a, b, c, d, e);
    }
}
