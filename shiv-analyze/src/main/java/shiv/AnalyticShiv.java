package shiv;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import shiv.analyzer.RecursiveDependencyAnalyzer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnalyticShiv implements Shiv {

    final static List<Analyzer> analyzers = new ArrayList<>();
    static {
        analyzers.add(new RecursiveDependencyAnalyzer());
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
        Problems<Graph<Class<?>, RelayEdge>> problems = registration.exportGraph().analyzable();

        if (problems.hasProblems()) {
            return Optional.of(problems.getProblems().get(0)); //TODO fix
        }

        List<Exception> exceptions = analyzers
                .stream()
                .map(analyzer -> analyzer.analyze(problems.getT()))
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
