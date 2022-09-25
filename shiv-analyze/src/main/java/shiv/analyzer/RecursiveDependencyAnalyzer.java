package shiv.analyzer;

import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.KosarajuStrongConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import shiv.Analyzer;
import shiv.checker.ShivCompileException;

import java.util.Optional;

public class RecursiveDependencyAnalyzer implements Analyzer {

    @Override
    public Optional<Exception> analyze(Graph<Class<?>, DefaultEdge> graph) {

        var kot = new KosarajuStrongConnectivityInspector<>(graph);

        var sets = kot.getStronglyConnectedComponents();

        for (Graph<Class<?>, DefaultEdge> subgraph : sets) {

            if (subgraph.edgeSet().size() > 0) {

                return Optional.of(new IllegalStateException("Error building dependency graph: ass: [" + subgraph.edgeSet())) ;
            }
        }

        return Optional.empty();
    }
}
