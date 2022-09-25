package shiv;

public class AnalyticProvider implements ShivProvider {
    @Override
    public Shiv provide(Module... modules) {

        AnalyticRegistration registration = new AnalyticRegistration();

        for (Module module : modules) {
            module.registerSubsystems(registration);
        }


        return new AnalyticShiv(registration);
    }

    @Override
    public byte priority() {
        return 2;
    }
}
