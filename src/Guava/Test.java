package Guava;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * Created by dingpeng on 2016/1/21.
 */
public class Test {

    private String name;

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = ImmutableList.of("1", "2", "3");
        filter(list);
    }

    static void filter(List<String> list) {
        for (Iterator<String> iter = list.iterator(); iter.hasNext(); ) {
            String item = iter.next();
            System.out.println(item);
        }
    }
}
