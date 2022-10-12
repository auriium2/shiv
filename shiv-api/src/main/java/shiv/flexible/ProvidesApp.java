package shiv.flexible;

public interface ProvidesApp<T> {

    WithApp.None<T> noDependencies();

    <A> WithApp.One<T,A> dependencies(Class<A> a);
    <A,B> WithApp.Two<T,A,B> dependencies(Class<A> a, Class<B> b);
    <A,B,C> WithApp.Three<T,A,B,C> dependencies(Class<A> a, Class<B> b, Class<C> c);
    <A,B,C,D> WithApp.Four<T,A,B,C,D> dependencies(Class<A> a, Class<B> b, Class<C> c, Class<D> d);
    <A,B,C,D,E> WithApp.Five<T,A,B,C,D,E> dependencies(Class<A> a, Class<B> b, Class<C> c, Class<D> d, Class<E> e);

}
