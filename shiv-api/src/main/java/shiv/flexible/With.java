package shiv.flexible;

public interface With {

    interface None<T> {
        void register(Initializer.None<T> init);
    }
    interface One<T,A> {
        void register(Initializer.One<T,A> init);
    }
    interface Two<T,A,B> {
        void register(Initializer.Two<T,A,B> init);
    }
    interface Three<T,A,B,C> {
        void register(Initializer.Three<T,A,B,C> init);
    }
    interface Four<T,A,B,C,D> {
        void register(Initializer.Four<T,A,B,C,D> init);
    }
    interface Five<T,A,B,C,D,E> {
        void register(Initializer.Five<T,A,B,C,D,E> init);
    }

}
