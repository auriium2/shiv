package shiv.flexible.selector;

import shiv.exception.ShivInternalException;
import shiv.exception.ShivIsBreakingException;
import shiv.flexible.Connector;
import shiv.flexible.ISelectable;
import shiv.flexible.ISelector;

import java.util.ArrayList;
import java.util.List;

public class TypedSelect<PARAM, T extends ISelectable<PARAM>, L extends ISelectable<?>> implements ISelector<T> {

    final Class<L> clazz;
    final Class<PARAM> type;

    public TypedSelect(Class<L> clazz, Class<PARAM> type) {
        this.clazz = clazz;
        this.type = type;
    }

    @SuppressWarnings("unchecked") //it's not type hackery i promise (it is)
    @Override
    public T provides(Object[] ob) throws ShivIsBreakingException {
        return (T) clazz.cast(ob[0]);
    }

    @Override
    public int[] select(Connector[] provideds) throws ShivInternalException {
        List<Integer> collect = new ArrayList<>();

        for (int i = 0; i < provideds.length; i++) {

            if (provideds[i].provides.isAssignableFrom(clazz)) {

                if (provideds[i].typed.length == 0) throw new ShivInternalException("wtf");
                if (provideds[i].typed[0].isAssignableFrom(type)) {
                    collect.add(i);
                }
            }

        }

        return toIntArray(collect);
    }

    int[] toIntArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        for(int i = 0; i < ret.length; i++)
            ret[i] = list.get(i);
        return ret;
    }



}
