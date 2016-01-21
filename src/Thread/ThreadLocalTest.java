package Thread;

import java.util.HashMap;

/**
 * Created by dingpeng on 2016/1/20.
 */
public class ThreadLocalTest {

    /**
     * public T get() {
     * Thread t = Thread.currentThread();
     * ThreadLocalMap map = getMap(t);
     * if (map != null) {
     * ThreadLocalMap.Entry e = map.getEntry(this);
     * if (e != null)
     * return (T)e.value;
     * }
     * return setInitialValue();
     * }
     **/

    static ThreadLocal<HashMap> map0 = new ThreadLocal<HashMap>() {
        @Override
        protected HashMap initialValue() {
            System.out.println(Thread.currentThread().getName() + "initialValue");
            return new HashMap();
        }
    };

    public void run() {
        Thread[] runs = new Thread[3];
        for (int i = 0; i < runs.length; i++) {
            runs[i] = new Thread(new T1(i));
        }
        for (int i = 0; i < runs.length; i++) {
            runs[i].start();
        }
    }

    public static class T1 implements Runnable {
        int id;

        public T1(int id0) {
            id = id0;
        }

        public void run() {
            System.out.println(Thread.currentThread().getName() + ":start");
            HashMap map = map0.get();
            for (int i = 0; i < 10; i++) {
                map.put(i, i + id * 100);
                try {
                    Thread.sleep(100);
                } catch (Exception ex) {
                }
            }
            System.out.println(Thread.currentThread().getName() + ':' + map);
        }
    }

    /**
     * Main
     *
     * @param args
     */
    public static void main(String[] args) {
        ThreadLocalTest test = new ThreadLocalTest();
        test.run();
    }
}