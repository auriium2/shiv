package shiv.flexible;

import java.io.Serializable;

/**
 * represents a function that initializes something, should typically be a method reference
 * if you have a class with a constructor(a,b) and Shiv is asking you for an Initializer.Two, you
 * can register your constructor there
 *
 */
public interface Initializer extends Serializable { //serializable in order to allow Java to save the method name during debugging

    interface None<OUT> extends Initializer {
        OUT provide();
    }

    interface One<OUT,A> extends Initializer {
        OUT provide(A a);
    }

    interface Two<OUT,A,B> extends Initializer {
        OUT provide(A a, B b);
    }

    interface Three<OUT,A,B,C> extends Initializer {
        OUT provide(A a, B b, C c);
    }

    interface Four<OUT,A,B,C,D> extends Initializer {
        OUT provide(A a, B b, C c, D d);
    }

    interface Five<OUT,A,B,C,D,E> extends Initializer {
        OUT provide(A a, B b, C c, D d, E e);
    }


}
