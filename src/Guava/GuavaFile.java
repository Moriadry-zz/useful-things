package Guava;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.ByteSource;
import com.google.common.io.Files;

/**
 * Created by dingpeng on 2016/1/21.
 */
public class GuavaFile {

    public static void main(String[] args) {

        //读取文件
        try {
            File file = new File("c://11.txt");

            List<String> list = Files.readLines(new File("c://11.txt"), Charsets.UTF_8);
            System.out.println(list.toString());

            //追加文件内容
            //Files.append("1111", new File("c://11.txt"), Charsets.UTF_8);

            ByteSource byteSource = Files.asByteSource(file);
            byte[] bytes = byteSource.read();
            System.out.println(bytes.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
