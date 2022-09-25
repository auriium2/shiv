package shiv;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnalyticShiv implements Shiv {

    final static List<Analyzer> analyzers = new ArrayList<>();
    static {
        analyzers.add(null);
    }


    final AnalyticRegistration registration;

    public AnalyticShiv(AnalyticRegistration registration) {
        this.registration = registration;
    }

    @Override
    public ShivApp build() {
        return new ShivAppImpl(registration.export());
    }

    @Override
    public Optional<Exception> verify() {
        Graph<Class<?>, DefaultEdge> graph = registration.exportGraph().analyzable();

        List<Exception> exceptions = analyzers
                .stream()
                .map(analyzer -> analyzer.analyze(graph))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        if (!exceptions.isEmpty()) {
            return Optional.of(exceptions.get(0)); //TODO multiple graph failure checks
        }


        return Optional.empty();
    }

    @Override
    public String name() {
        return "analytic";
    }
}
