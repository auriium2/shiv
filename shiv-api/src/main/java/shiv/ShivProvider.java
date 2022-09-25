package shiv;

public interface ShivProvider {

    Shiv provide(Module... modules);
    byte priority(); //higher is more priority

}
