package shiv.provider;

import shiv.Module;
import shiv.internal.Provider;


public class Provider2Impl<T,A> implements Provider<T> {

    final Module.ProvidingFunction2<T,A> depFunc;
    final Class<T> provides;
    final Class<A> clazzA;

    public Provider2Impl(Module.ProvidingFunction2<T, A> depFunc, Class<T> provides, Class<A> clazzA) {
        this.depFunc = depFunc;
        this.provides = provides;
        this.clazzA = clazzA;
    }

    @Override
    public T provide(Provider.Function provideFunction) {
        A a = provideFunction.generate(clazzA); //t wants a (now how do we track if a wants t)

        return depFunc.provide(a);
    }

    @Override
    public Class<?> mostSpecificProvides() {
        return provides;
    }

}
