package shiv.flexible.selector;

import shiv.exception.ShivInternalException;
import shiv.exception.ShivIsBreakingException;
import shiv.flexible.Connector;
import shiv.flexible.ISelector;

public class CompoundSelector<T> implements ISelector<T> {

    //list of other selectors

    final ISelector<?>[] selectors;

    public CompoundSelector(ISelector<?>[] selectors) {
        this.selectors = selectors;
    }

    @Override
    public int[] select(Connector[] provideds) throws ShivInternalException {
        for (ISelector<?> selector : selectors) {
            selector.select(provideds);
        }
    }

    @Override
    public T provides(Object[] ob) throws ShivIsBreakingException {
        return null;
    }
}
