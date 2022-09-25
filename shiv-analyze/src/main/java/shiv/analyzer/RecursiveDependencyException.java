package shiv.analyzer;

import org.jgrapht.graph.DefaultEdge;
import shiv.checker.ShivCompileException;

import java.util.Set;
import java.util.function.Supplier;

public class RecursiveDependencyException extends ShivCompileException {



    public RecursiveDependencyException(String str) {
        super(
                str,
                null,
                false,
                false
        );
    }
}
