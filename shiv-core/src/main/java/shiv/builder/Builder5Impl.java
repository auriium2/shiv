package shiv.builder;

import shiv.Module;
import shiv.internal.GraphRepresentation;
import shiv.internal.Provider;
import shiv.provider.Provider5Impl;

import java.util.List;

public class Builder5Impl<T,A,B,C,D> implements Module.Builder5<T,A,B,C,D>{

    final List<Provider<?>> providerList;
    final GraphRepresentation representation;

    final Class<T> in;
    final Class<A> a;
    final Class<B> b;
    final Class<C> c;
    final Class<D> d;

    public Builder5Impl(List<Provider<?>> providerList, GraphRepresentation representation, Class<T> in, Class<A> a, Class<B> b, Class<C> c, Class<D> d) {
        this.providerList = providerList;
        this.representation = representation;
        this.in = in;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public void register(Module.ProvidingFunction5<T, A, B, C, D> func) {
        representation.vertex(in);
        representation.edge(in, a);
        representation.edge(in, b);
        representation.edge(in, c);
        representation.edge(in, d);

        providerList.add(new Provider5Impl<>(func, in, a, b, c, d));
    }
}
