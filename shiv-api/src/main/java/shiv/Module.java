package shiv;

public interface Module {

    interface Builder1<OUT> {
        <A> Builder2<OUT,A> dependsOn(Class<A> depends);

        void register(ProvidingFunction1<OUT> func);
    }

    interface Builder2<OUT,A> {
        <B> Builder3<OUT,A,B> dependsOn(Class<B> depends);

        void register(ProvidingFunction2<OUT,A> func);
    }

    interface Builder3<OUT,A,B> {
        <C> Builder4<OUT,A,B,C> dependsOn(Class<C> depends);

        void register(ProvidingFunction3<OUT,A,B> func);
    }

    interface Builder4<OUT,A,B,C> {
        <D> Builder5<OUT,A,B,C,D> dependsOn(Class<D> depends);

        void register(ProvidingFunction4<OUT,A,B,C> func);
    }

    interface Builder5<OUT,A,B,C,D> {
        void register(ProvidingFunction5<OUT,A,B,C,D> func);
    }

    interface ProvidingFunction1<OUT> {
        OUT provide();
    }

    interface ProvidingFunction2<OUT,A> {
        OUT provide(A a);
    }

    interface ProvidingFunction3<OUT,A,B> {
        OUT provide(A a, B b);
    }

    interface ProvidingFunction4<OUT,A,B,C> {
        OUT provide(A a, B b, C c);
    }

    interface ProvidingFunction5<OUT,A,B,C,D> {
        OUT provide(A a, B b, C c, D d);
    }

    void registerSubsystems(Shiv.Registration subsystemRegistration);

}
