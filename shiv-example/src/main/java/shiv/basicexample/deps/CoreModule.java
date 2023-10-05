package shiv.basicexample.deps;

import shiv.Shiv;

public class CoreModule implements Module {


    @Override
    public void registerSubsystems(Shiv.Registration subsystemRegistration) {
        subsystemRegistration
                .provides(Core.class)
                .register(this::provideCore);

        subsystemRegistration
                .provides(CoreUser.class)
                .dependsOn(Core.class)
                .register(this::provideUser);

        subsystemRegistration
                .provides(SmartCoreUser.class)
                .dependsOn(Core.class)
                .dependsOn(CoreUser.class)
                .register(this::provideSmartUser);

        subsystemRegistration
                .provides(CoreChecker.class)
                .dependsOn(Core.class)
                .register(this::provideCoreChecker);
    }

    public Core provideCore() {
        return new Core();
    }

    public CoreUser provideUser(Core core) {
        return new CoreUser(core);
    }

    public SmartCoreUser provideSmartUser(Core core, CoreUser smartCoreUser) {
        return new SmartCoreUser(core, smartCoreUser); //don't allow smartcoreuser(smartcoreuser)
    }

    public CoreChecker provideCoreChecker(Core core) {
        return new CoreChecker(core);
    }
}
