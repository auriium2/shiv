package shiv.impl;

import shiv.flexible.Provides;
import shiv.flexible.With;

/**
 * fancy way of doing a builder that restricts nullity
 * @param <T> dont touch this
 */
class ProvidesImpl<T> implements Provides<T> {

    final Class<T> providedClass;

    public ProvidesImpl(Class<T> providedClass) {
        this.providedClass = providedClass;
    }

    @Override
    public With.None<T> noDependencies() {
        return new WithImpl<>(providedClass, null, null, null, null, null);
    }

    @Override
    public <A> With.One<T, A> dependencies(Class<A> a) {
        return new WithImpl<>(providedClass, a, null, null, null, null);
    }

    @Override
    public <A, B> With.Two<T, A, B> dependencies(Class<A> a, Class<B> b) {
        return new WithImpl<>(providedClass, a, b, null, null, null);
    }

    @Override
    public <A, B, C> With.Three<T, A, B, C> dependencies(Class<A> a, Class<B> b, Class<C> c) {
        return new WithImpl<>(providedClass, a, b, c, null, null);
    }

    @Override
    public <A, B, C, D> With.Four<T, A, B, C, D> dependencies(Class<A> a, Class<B> b, Class<C> c, Class<D> d) {
        return new WithImpl<>(providedClass, a, b, c, d, null);
    }

    @Override
    public <A, B, C, D, E> With.Five<T, A, B, C, D, E> dependencies(Class<A> a, Class<B> b, Class<C> c, Class<D> d, Class<E> e) {
        return new WithImpl<>(providedClass, a, b, c, d, e);
    }
}
