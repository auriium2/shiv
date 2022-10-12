package shiv.impl;

import shiv.Shiv;
import shiv.internal.ShivProvider;

public class DefaultProvider implements ShivProvider {


    @Override
    public Shiv provide() {
        return null;
    }

    @Override
    public byte priority() {
        return 1;
    }


}
