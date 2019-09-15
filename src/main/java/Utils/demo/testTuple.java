package Utils.demo;

import Utils.Tuple;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2019/5/31 17 :07
 *
 * @author moubin.mo
 */

public class testTuple {
    public static void main(String [] args){


    }

    private List<Tuple<String, Object>> toTupleList(String key, Object value) {
        List<Tuple<String, Object>> list = new ArrayList<>();
        Tuple<String, Object> variable = new Tuple<>(key, value);
        list.add(variable);
        return list;
    }
}
