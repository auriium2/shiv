package shiv.flexible;

import java.io.Serializable;

/**
 * this has to be serializable in order for the analysis class to
 * do compile time reflection and build function name graphs.
 *
 * represents a function that initializes something, should typically be a method reference
 *
 */
public interface Initializer extends Serializable {

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
