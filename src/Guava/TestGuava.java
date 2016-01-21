package Guava;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.io.Files;

/**
 * Created by dingpeng on 2016/1/21.
 */
public class TestGuava {
    public static void main(String[] args) {
		/*System.out.println(Joiner.on(' ').join(1, 2, 3));
		Map<String,String> map = new HashMap<String,String>();

		map.put("1", "111");
		map.put("2", "222");
		map.put(null, null);

		String s = Joiner.on("#").useForNull("none").withKeyValueSeparator("-").join(map);
		System.out.println(s);
		int i = 1;
		Preconditions.checkArgument(i>0);

		StringUtils.isNotBlank("");

		Maps.newHashMap();
		newHashMap();
		for (int j = 0; j < args.length; j++) {

		}*/
        Map<String,String> map = Maps.newHashMap();
        Map<Integer,Integer> map1 = ImmutableMap.of(1,2,3,4);
        System.out.println(map1.get(1)+","+map1.get(3));

        try {
            List<String> list = Files.readLines(new File("c://11.txt"), Charsets.UTF_8);
            System.out.println(list.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

