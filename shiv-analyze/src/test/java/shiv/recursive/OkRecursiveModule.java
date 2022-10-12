package shiv.recursive;

import shiv.Shiv;

public class OkRecursiveModule implements Module {

    class A {

    }

    class B {
        final A a;

        public B(A a) {
            this.a = a;
        }
    }

    @Override
    public void registerSubsystems(Shiv.Registration subsystemRegistration) {

        subsystemRegistration
                .provides(A.class)
                .register(A::new);

        subsystemRegistration
                .provides(B.class)
                .dependsOn(A.class)
                .register(B::new);
    }
}
