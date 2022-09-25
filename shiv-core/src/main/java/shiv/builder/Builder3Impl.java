package shiv.builder;

import shiv.provider.Provider3Impl;
import shiv.Module;
import shiv.internal.GraphRepresentation;
import shiv.internal.Provider;

import java.util.List;

public class Builder3Impl<T,A,B> implements Module.Builder3<T,A,B> {

    final List<Provider<?>> providerList;
    final GraphRepresentation representation;

    final Class<T> in;
    final Class<A> a;
    final Class<B> b;

    public Builder3Impl(List<Provider<?>> providerList, GraphRepresentation representation, Class<T> in, Class<A> a, Class<B> b) {
        this.providerList = providerList;
        this.representation = representation;
        this.in = in;
        this.a = a;
        this.b = b;
    }

    @Override
    public <C> Module.Builder4<T, A, B, C> dependsOn(Class<C> depends) {
        return new Builder4Impl<>(providerList, representation, in, a, b, depends);
    }

    @Override
    public void register(Module.ProvidingFunction3<T, A, B> func) {
        representation.vertex(in);
        representation.edge(in, a);
        representation.edge(in, b);

        providerList.add(new Provider3Impl<>(func, in, a, b));
    }
}
