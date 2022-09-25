package shiv.basicexample.deps;

public class CoreChecker {

    final Core core;

    public CoreChecker(Core core) {
        this.core = core;
    }

    public boolean isCorrect() {
        return core.coreCounter() == 2;
    }
}
