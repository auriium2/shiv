package shiv;

import shiv.exception.ShivInternalException;
import shiv.flexible.Connector;
import shiv.flexible.ISelector;

import java.util.Arrays;

public class ConnectorProcessor {

    final ISelector<?> someSelector;
    final Connector[] connectors;

    public ConnectorProcessor(ISelector<?> someSelector, Connector[] connectors) {
        this.someSelector = someSelector;
        this.connectors = connectors;
    }

    public void process() throws ShivInternalException {


        int[][] db = new int[connectors.length][];

        for (int i = 0; i < connectors.length; i++) {
            
        }




    }

    public int[] extractRequirements(int index) throws ShivInternalException {
        int[] list = new int[0];

        for (ISelector<?> i : connectors[index].requires) {
            list = concat(list, i.select(connectors)); //append
        }

        return list;
    }

    static int[] concat(int[] array1, int[] array2) {
        int[] result = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }
}
