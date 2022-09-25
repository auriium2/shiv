package shiv.provider;

import shiv.Module;
import shiv.internal.Provider;

public class Provider4Impl<T,A,B,C> implements Provider<T> {

    final Module.ProvidingFunction4<T,A,B,C> func;
    final Class<T> provides;
    final Class<A> a;
    final Class<B> b;
    final Class<C> c;

    public Provider4Impl(Module.ProvidingFunction4<T, A, B, C> func, Class<T> provides, Class<A> a, Class<B> b, Class<C> c) {
        this.func = func;
        this.provides = provides;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public T provide(Function provider) {
        A aob = provider.generate(a);
        B bob = provider.generate(b);
        C cob = provider.generate(c);

        return func.provide(aob, bob, cob);
    }

    @Override
    public Class<?> mostSpecificProvides() {
        return provides;
    }
}
