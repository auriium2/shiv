package shiv;

import shiv.flexible.ISelector;

public interface IProvides<T> {

    IWith.None<T> noDependencies();

    <A> IWith.One<T,A> dependencies(ISelector<A> a);
    <A,B> IWith.Two<T,A,B> dependencies(ISelector<A> a, ISelector<B> b);
    <A,B,C> IWith.Three<T,A,B,C> dependencies(ISelector<A> a, ISelector<B> b, ISelector<C> c);
    <A,B,C,D> IWith.Four<T,A,B,C,D> dependencies(ISelector<A> a, ISelector<B> b, Class<C> c, ISelector<D> d);
    <A,B,C,D,E> IWith.Five<T,A,B,C,D,E> dependencies(ISelector<A> a, ISelector<B> b, ISelector<C> c, ISelector<D> d, ISelector<E> e);

}
