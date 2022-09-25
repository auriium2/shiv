package shiv.provider;

import shiv.Module;
import shiv.internal.Provider;

public class Provider5Impl<OUT, A, B, C, D> implements Provider<OUT> {

    final Module.ProvidingFunction5<OUT,A,B,C,D> func;
    final Class<OUT> out;
    final Class<A> a;
    final Class<B> b;
    final Class<C> c;
    final Class<D> d;

    public Provider5Impl(Module.ProvidingFunction5<OUT, A, B, C, D> func, Class<OUT> out, Class<A> a, Class<B> b, Class<C> c, Class<D> d) {
        this.func = func;
        this.out = out;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public OUT provide(Function provider) {
        A aob = provider.generate(a);
        B bob = provider.generate(b);
        C cob = provider.generate(c);
        D dob = provider.generate(d);


        return func.provide(aob, bob, cob, dob);
    }

    @Override
    public Class<?> mostSpecificProvides() {
        return out;
    }
}
