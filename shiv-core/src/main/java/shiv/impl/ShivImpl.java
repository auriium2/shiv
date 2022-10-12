package shiv.impl;

import shiv.Shiv;
import shiv.exception.DuplicateApplicationException;
import shiv.flexible.Provides;
import shiv.flexible.ProvidesApp;

public class ShivImpl implements Shiv {

    //hide stuff in here

    boolean hasApplicationUsedYet = false;


    @Override
    public <T> Provides<T> withProvider(Class<T> t) {
        return null;
    }

    @Override
    public <T> ProvidesApp<T> withApplication() {
        return null;
    }

    void throwIfUsed() throws DuplicateApplicationException {
        if (hasApplicationUsedYet) throw new DuplicateApplicationException();
    }



}
