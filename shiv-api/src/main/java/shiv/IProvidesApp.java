package shiv;

import shiv.flexible.ISelector;

public interface IProvidesApp<T> {

    <A> IWithApp.One<T,A> dependencies(ISelector<A> a);
    <A,B> IWithApp.Two<T,A,B> dependencies(ISelector<A> a, ISelector<B> b);
    <A,B,C> IWithApp.Three<T,A,B,C> dependencies(ISelector<A> a, ISelector<B> b, ISelector<C> c);
    <A,B,C,D> IWithApp.Four<T,A,B,C,D> dependencies(Class<A> a, Class<B> b, Class<C> c, Class<D> d);
    <A,B,C,D,E> IWithApp.Five<T,A,B,C,D,E> dependencies(Class<A> a, Class<B> b, Class<C> c, Class<D> d, Class<E> e);

}
