package shiv;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import shiv.internal.GraphRepresentation;

import java.util.ArrayList;
import java.util.List;

//use jgrapht
public class AnalyticGraph implements GraphRepresentation {

    static class Edge {
        final Class<?> parent;
        final Class<?> depender;

        public Edge(Class<?> parent, Class<?> depender) {
            this.parent = parent;
            this.depender = depender;
        }
    }

    final List<Class<?>> vertexAddList = new ArrayList<>();
    final List<Edge> edgeAddList = new ArrayList<>();


    @Override
    public void vertex(Class<?> supplied) {
        vertexAddList.add(supplied);
    }

    @Override
    public void edge(Class<?> user, Class<?> required) {
        edgeAddList.add(new Edge(user, required));
    }

    Graph<Class<?>, DefaultEdge> analyzable() {

        Graph<Class<?>,DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);
        for (Class<?> vertex : vertexAddList) {
            graph.addVertex(vertex);
        }

        for (Edge edge : edgeAddList) {
            graph.addEdge(edge.parent, edge.depender);
        }

        return graph;

    }
}
