package shiv;

import org.jgrapht.graph.DefaultEdge;

public class RelayEdge extends DefaultEdge {

    public Object source() {
        return getSource();
    }

    public Object target() {
        return getTarget();
    }

}
