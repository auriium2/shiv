package shiv.internal;

public interface GraphRepresentation {

    void vertex(Class<?> supplied);
    void edge(Class<?> user, Class<?> required);

}
