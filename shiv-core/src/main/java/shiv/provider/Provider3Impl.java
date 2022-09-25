package shiv.provider;

import shiv.Module;
import shiv.internal.Provider;

public class Provider3Impl<T,A,B> implements Provider<T> {

    final Module.ProvidingFunction3<T,A,B> depFunc;
    final Class<T> t;
    final Class<A> clazzA;
    final Class<B> clazzB;

    public Provider3Impl(Module.ProvidingFunction3<T, A, B> depFunc, Class<T> t, Class<A> clazzA, Class<B> clazzB) {
        this.depFunc = depFunc;
        this.t = t;
        this.clazzA = clazzA;
        this.clazzB = clazzB;
    }

    @Override
    public T provide(Provider.Function provideFunction) {

        A a = provideFunction.generate(clazzA);
        B b = provideFunction.generate(clazzB);

        return depFunc.provide(a,b);
    }

    @Override
    public Class<?> mostSpecificProvides() {
        return t;
    }
}
