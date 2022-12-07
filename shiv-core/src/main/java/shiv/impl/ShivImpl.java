package shiv.impl;

import shiv.Shiv;
import shiv.exception.DuplicateApplicationException;
import shiv.IProvides;
import shiv.IProvidesApp;

public class ShivImpl implements Shiv {

    //hide stuff in here

    boolean hasApplicationUsedYet = false;


    @Override
    public <T> IProvides<T> withProvider(Class<T> t) {
        return null;
    }

    @Override
    public <T> IProvidesApp<T> withApplication() {
        return null;
    }

    void throwIfUsed() throws DuplicateApplicationException {
        if (hasApplicationUsedYet) throw new DuplicateApplicationException();
    }



}
