package shiv.internal;

import shiv.Shiv;

public interface ShivProvider {

    Shiv provide();
    byte priority(); //higher is more priority

}
