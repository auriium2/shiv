package shiv;

import java.util.List;

public class Problems<T> {

    final List<Exception> problems;
    final T t;

    public Problems(List<Exception> problems, T t) {
        this.problems = problems;
        this.t = t;
    }

    public List<Exception> getProblems() {
        return problems;
    }

    public T getT() {
        return t;
    }

    boolean hasProblems() {
        return !problems.isEmpty();
    }
}
