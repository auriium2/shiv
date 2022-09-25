package shiv;

import shiv.builder.Builder1Impl;
import shiv.internal.GraphRepresentation;
import shiv.internal.Provider;

import java.util.ArrayList;
import java.util.List;

public class AnalyticRegistration implements Shiv.Registration {

    final List<Provider<?>> providers = new ArrayList<>();
    final AnalyticGraph graph = new AnalyticGraph();

    @Override
    public <T> Module.Builder1<T> provides(Class<T> returnType) {
        return new Builder1Impl<>(providers, graph, returnType);
    }

    AnalyticGraph exportGraph() {
        return graph;
    }

    List<Provider<?>> export() {
        return providers;
    }
}
