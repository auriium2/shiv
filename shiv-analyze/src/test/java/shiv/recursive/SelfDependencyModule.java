package shiv.recursive;

import shiv.Shiv;

public class SelfDependencyModule implements Module  {

    class A {
        final A a;

        public A(A a) {
            this.a = a;
        }
    }

    @Override
    public void registerSubsystems(Shiv.Registration subsystemRegistration) {
        subsystemRegistration
                .provides(A.class)
                .dependsOn(A.class)
                .register(A::new);
    }
}
