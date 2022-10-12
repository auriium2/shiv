package shiv;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import shiv.analyzer.MissingProviderException;

import java.util.ArrayList;
import java.util.List;

//use jgrapht
public class AnalyticGraph implements GraphRepresentation {

    public static class Edge {
        final Class<?> provided;
        final Class<?> required;

        public Edge(Class<?> provided, Class<?> required) {
            this.provided = provided;
            this.required = required;
        }
    }

    final List<Class<?>> vertexAddList = new ArrayList<>();
    final List<Edge> edgeAddList = new ArrayList<>();


    @Override
    public void vertex(Class<?> provided) {
        vertexAddList.add(provided);
    }

    @Override
    public void edge(Class<?> provided, Class<?> required) {
        edgeAddList.add(new Edge(provided, required));
    }

    Problems<Graph<Class<?>, RelayEdge>> analyzable() {

        //TODO clean this shit up
        List<Exception> issues = new ArrayList<>();
        Graph<Class<?>,RelayEdge> graph = new DefaultDirectedGraph<>(RelayEdge.class);
        for (Class<?> vertex : vertexAddList) {
            graph.addVertex(vertex);
        }


        StringBuilder builder = new StringBuilder("[Shiv/MissingProvider]")
                .append("\n\nError: Some of your providers (A) have dependencies on certain classes (B) but no providers exist to provide classes of type (B)");

        int counter = 0;
        for (Edge edge : edgeAddList) {


            if (!vertexAddList.contains(edge.required)) {
                counter++;

                builder
                        .append("\n\tClass ").append(edge.provided).append(" depends on class ").append(edge.required)
                        .append(" (missing provider)");
            } else {
                graph.addEdge(edge.provided, edge.required);
            }

        }

        builder.append("\n\nPlease implement methods to provide the classes marked as (missing provider) and recompile");

        if (counter > 0) {
            issues.add(new MissingProviderException(builder.toString()));
        }

        return new Problems<>(issues, graph);

    }
}
