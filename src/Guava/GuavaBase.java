package Guava;

import java.util.List;
import java.util.Map;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Splitter.MapSplitter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

/**
 * Created by dingpeng on 2016/1/21.
 */
public class GuavaBase {

    public static void main(String[] args) {
        //testJoiner();
        //testSplitter();
        //testCharMatcher();
        //testPreconditions();

        System.out.println(Strings.commonPrefix("abc", "abcd"));
        List<String> list = Lists.newArrayList("1","2");
        System.out.println(list);
    }

    public static void testJoiner() {
        String array[] = {"1","2",null,"3"};
        String newArray = Joiner.on(";").useForNull("none").join(array);
        System.out.println(newArray);

        List<String> list = null;
        try {
            list = ImmutableList.of("a","b","c");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String newList = Joiner.on("#").skipNulls().join(list);
        System.out.println(newList.trim());

        StringBuilder sb = new StringBuilder();
        Joiner joiner = Joiner.on(",").skipNulls();
        sb = joiner.appendTo(sb, "aaa",null,"bbb");
        System.out.println(sb.toString());


        Map<String,String> map = ImmutableMap.of("key1", "value1", "key2", "value2");
        String mapStr = Joiner.on(",").withKeyValueSeparator("->").join(map);
        System.out.println(mapStr);

    }

    public static void testSplitter() {
        String s = "a,b  ,c  ,d  ";
        Iterable<String> iter = Splitter.on(",").trimResults().split(s);
        System.out.println(iter);

        String mapS = "key1=value1,key2=value2";
        MapSplitter mapSplitter = Splitter.on(",").withKeyValueSeparator("=");
        Map<String,String> map = mapSplitter.split(mapS);
        System.out.println(map.toString());

        System.out.println("emptyToNull:"+Strings.emptyToNull(""));
        System.out.println("nullToEmpty:"+Strings.nullToEmpty(null));
        System.out.println("padEnd:"+Strings.padEnd("123", 5, 'a'));
        System.out.println("padStart:"+Strings.padStart("123", 5, 'b'));

    }

    public static void testCharMatcher() {

        String s1 = " a b  c d ";

        //ȥ������ո�
        String newS1 = CharMatcher.WHITESPACE.collapseFrom(s1, ' ');
        System.out.println(newS1);

        //ȥ����β�ո�
        String newS12 = CharMatcher.WHITESPACE.trimAndCollapseFrom(s1, ' ');
        System.out.println("1"+newS12+"2");

        //��������
        String s2 = "abc123 def345 aa";
        String newS2 = CharMatcher.JAVA_DIGIT.retainFrom(s2);
        System.out.println(newS2);

        //�������ֺͿո�
        String newS22 = CharMatcher.JAVA_DIGIT.or(CharMatcher.WHITESPACE).retainFrom(s2);
        System.out.println(newS22);
    }

    public static void testPreconditions() {
        String s = "abc";
        String s1 = null;
        //Preconditions.checkNotNull(s1);

        String array[] = {"1","2","2"};
        //Preconditions.checkElementIndex(3, array.length, "����");

        //Preconditions.checkArgument(100>101);

        Preconditions.checkState(100>101, "����");
    }
}
