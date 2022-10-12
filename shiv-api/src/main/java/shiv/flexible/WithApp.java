package shiv.flexible;

import shiv.Application;

public interface WithApp {

    interface None<T> {
        Application<T> register(Initializer.None<T> init);
    }
    interface One<T,A> {
        Application<T> register(Initializer.One<T,A> init);
    }
    interface Two<T,A,B> {
        Application<T> register(Initializer.Two<T,A,B> init);
    }
    interface Three<T,A,B,C> {
        Application<T> register(Initializer.Three<T,A,B,C> init);
    }
    interface Four<T,A,B,C,D> {
        Application<T> register(Initializer.Four<T,A,B,C,D> init);
    }
    interface Five<T,A,B,C,D,E> {
        Application<T> register(Initializer.Five<T,A,B,C,D,E> init);
    }

}
