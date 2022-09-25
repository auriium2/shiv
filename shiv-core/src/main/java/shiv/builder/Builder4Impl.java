package shiv.builder;

import shiv.Module;
import shiv.internal.GraphRepresentation;
import shiv.internal.Provider;
import shiv.provider.Provider4Impl;

import java.util.List;

public class Builder4Impl<T,A,B,C> implements Module.Builder4<T,A,B,C>{

    final List<Provider<?>> providerList;
    final GraphRepresentation representation;

    final Class<T> in;
    final Class<A> a;
    final Class<B> b;
    final Class<C> c;

    public Builder4Impl(List<Provider<?>> providerList, GraphRepresentation representation, Class<T> in, Class<A> a, Class<B> b, Class<C> c) {
        this.providerList = providerList;
        this.representation = representation;
        this.in = in;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public <D> Module.Builder5<T, A, B, C, D> dependsOn(Class<D> depends) {
        return new Builder5Impl<>(providerList, representation, in, a, b, c, depends);
    }

    @Override
    public void register(Module.ProvidingFunction4<T, A, B, C> func) {
        representation.vertex(in);
        representation.edge(in, a);
        representation.edge(in, b);
        representation.edge(in, c);

        providerList.add(new Provider4Impl<>(func, in, a, b, c));
    }
}
