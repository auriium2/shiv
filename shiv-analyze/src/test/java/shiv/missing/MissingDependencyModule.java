package shiv.missing;

import shiv.Shiv;

public class MissingDependencyModule implements Module {

    @Override
    public void registerSubsystems(Shiv.Registration subsystemRegistration) {
        subsystemRegistration
                .provides(B.class)
                .dependsOn(A.class)
                .register(B::new);
    }

    class A {

    }

    class B {
        final A a;

        public B(A a) {
            this.a = a;
        }
    }



}
