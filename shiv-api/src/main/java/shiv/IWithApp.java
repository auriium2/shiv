package shiv;

import shiv.IApplicationHandle;
import shiv.flexible.Initializer;

public interface IWithApp {

    interface One<T,A> {
        IApplicationHandle<T> register(Initializer.One<T,A> init);
    }
    interface Two<T,A,B> {
        IApplicationHandle<T> register(Initializer.Two<T,A,B> init);
    }
    interface Three<T,A,B,C> {
        IApplicationHandle<T> register(Initializer.Three<T,A,B,C> init);
    }
    interface Four<T,A,B,C,D> {
        IApplicationHandle<T> register(Initializer.Four<T,A,B,C,D> init);
    }
    interface Five<T,A,B,C,D,E> {
        IApplicationHandle<T> register(Initializer.Five<T,A,B,C,D,E> init);
    }

}
