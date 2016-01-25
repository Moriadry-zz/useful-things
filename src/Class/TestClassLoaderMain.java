package Class;

/**
 * Created by dingpeng on 2016/1/22.
 */
public class TestClassLoaderMain {

    class MyRunner extends Thread {
        @Override
        public void run() {
            int i = 0;
            while(i<Integer.MAX_VALUE){
                System.out.println(i+" while循环");
                i++;
            }
        }
    }

    public static void main (String[] args){
        TestClassLoader liuLoader = new TestClassLoader();
        TestClassLoaderMain tm = new TestClassLoaderMain();
        MyRunner runner = tm.new MyRunner();

        runner.setContextClassLoader(liuLoader);

        runner.start();
    }
}
