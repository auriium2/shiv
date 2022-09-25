package shiv.recursive;

import shiv.Module;
import shiv.Shiv;

public class EvilRecursiveModule implements Module {

    @Override
    public void registerSubsystems(Shiv.Registration subsystemRegistration) {
        subsystemRegistration
                .provides(A.class)
                .dependsOn(B.class)
                .register(A::new);

        subsystemRegistration
                .provides(B.class)
                .dependsOn(A.class)
                .register(B::new);
    }

    class A {
        final B b;

        public A(B b) {
            this.b = b;
        }
    }

    class B {
        final A a;

        public B(A a) {
            this.a = a;
        }
    }

}
