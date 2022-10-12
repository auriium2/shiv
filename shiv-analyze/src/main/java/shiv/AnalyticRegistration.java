package shiv;

import shiv.builder.Builder1Impl;
import shiv.internal.InternalProvider;

import java.util.ArrayList;
import java.util.List;

public class AnalyticRegistration implements Shiv.Registration {

    final List<InternalProvider<?>> internalProviders = new ArrayList<>();
    final AnalyticGraph graph = new AnalyticGraph();

    @Override
    public <T> Module.Builder1<T> provides(Class<T> returnType) {
        return new Builder1Impl<>(internalProviders, graph, returnType);
    }

    AnalyticGraph exportGraph() {
        return graph;
    }

    List<InternalProvider<?>> export() {
        return internalProviders;
    }
}
