package shiv.basicexample.deps;

public class CoreUser {

    final Core core;

    public CoreUser(Core core) {
        this.core = core;
    }

    public void use() {
        core.coreFunctionA();
    }
}
