package shiv.flexible;

import shiv.exception.ShivInternalException;
import shiv.exception.ShivIsBreakingException;

public interface ISelector<T> {

    //describes what needs to be "selected"
    int[] select(Connector[] provideds) throws ShivInternalException;

    //describes how to convert the selected stuff to T
    T provides(Object[] ob) throws ShivIsBreakingException;

}
