package shiv.basicexample.deps;

import jakarta.inject.Inject;

public class CoreUser {

    @Inject
    Core core;

    @Inject
    public CoreUser(Core core) {
        this.core = core;
    }

    public void use() {
        core.coreFunctionA();
    }
}
