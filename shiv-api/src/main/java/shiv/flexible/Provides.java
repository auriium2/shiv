package shiv.flexible;

public interface Provides<T> {

    With.None<T> noDependencies();

    <A> With.One<T,A> dependencies(Class<A> a);
    <A,B> With.Two<T,A,B> dependencies(Class<A> a, Class<B> b);
    <A,B,C> With.Three<T,A,B,C> dependencies(Class<A> a, Class<B> b, Class<C> c);
    <A,B,C,D> With.Four<T,A,B,C,D> dependencies(Class<A> a, Class<B> b, Class<C> c, Class<D> d);
    <A,B,C,D,E> With.Five<T,A,B,C,D,E> dependencies(Class<A> a, Class<B> b, Class<C> c, Class<D> d, Class<E> e);

}
