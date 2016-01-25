package Class;

/**
 * 类、变量初始化机制
 * 按照类的装载、链接和初始化逻辑，以及对象初始化的顺序来思考
 * 顺序：类的装载 -> 链接（验证 -> 准备 -> 解析） -> 初始化 -> 对象实例化
 * Created by dingpeng on 2016/1/25.
 */
class T  implements Cloneable{
    //static，类T的静态成员变量，需要在类加载的过程中被执行初始化。
    public static int k = 0;
    public static T t1 = new T("t1");
    public static T t2 = new T("t2");
    public static int i = print("i");
    public static int n = 99;

    //实例成员变量，只在类被实例化的过程中初始化
    public int j = print("j");
    {
        print("构造块");
    }

    static {
        print("静态块");
    }

    //构造方法是个实例化方法，在 T 被实例化时调用
    public T(String str) {
        System.out.println((++k) + ":" + str + "    i=" + i + "  n=" + n);
        ++n; ++ i;
    }

    public static int print(String str){
        System.out.println((++k) +":" + str + "   i=" + i + "   n=" + n);
        ++n;
        return ++ i;
    }

    public static void main(String[] args){
        T t = new T("init");
    }
}
