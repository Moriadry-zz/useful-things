package Class;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 未使用默认的双亲委托
 * 简单的判断如果是java.开始的包则用父类去解析，能简单的满足双亲委托机制，但是其他相关非系统类加载也没有用父类加载了。
 *
 * Created by dingpeng on 2016/1/21.
 */
public class TestClassLoader extends ClassLoader {

    //定义文件所在目录

    private static final String DEAFAULTDIR="E:\\MyProjects\\workspace\\TestConsole\\bin\\";



    public Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] b = null;

        try {

            b = loadClassData(GetClassName(name));

        } catch (Exception e) {

            e.printStackTrace();

        }

        return defineClass(name, b, 0, b.length);

    }

    @Override

    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {

        if(name.startsWith("java.")){try {

            return super.loadClass(name, false);

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        }

        byte[] b = null;

        try {

            b = loadClassData(GetClassName(name));

        } catch (Exception e) {

            e.printStackTrace();

        }

        return defineClass(name, b, 0, b.length);

    }

    private byte[] loadClassData(String filepath) throws Exception {

        int n =0;

        BufferedInputStream br = new BufferedInputStream(

                new FileInputStream(

                        new File(filepath)));

        ByteArrayOutputStream bos= new ByteArrayOutputStream();

        while((n=br.read())!=-1){

            bos.write(n);

        }

        br.close();

        return bos.toByteArray();

    }

    public static String GetClassName(String name){

        return DEAFAULTDIR+name.replace('.','/')+".class";

    }

}