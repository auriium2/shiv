package shiv.flexible.selector;

import shiv.flexible.ISelector;

import java.util.ArrayList;
import java.util.List;

//select should collect objects and composite them
public class ListSelector<T> implements ISelector<List<T>> {

    final Class<T> clazz;

    public ListSelector(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public boolean[] select(Outputs[] provideds) {
        boolean[] sel = new boolean[provideds.length];

        for (int i = 0; i < provideds.length; i++) {
            sel[i] = provideds[i].provides.isAssignableFrom(clazz);
        }

        return sel;
    }

    @Override
    public List<T> provides(Object[] ob) {
        List<T> list = new ArrayList<>();

        for (Object obb : ob) {
            list.add(clazz.cast(obb));
        }

        return list;
    }
}
