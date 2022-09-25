package shiv;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import java.util.Optional;

public interface Analyzer {

    Optional<Exception> analyze(Graph<Class<?>, DefaultEdge> graph);

}
