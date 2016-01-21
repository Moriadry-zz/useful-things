package Guava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dingpeng on 2016/1/21.
 */
public class ReadFile {

    public static void main(String[] args) {
        try {
            String path = ReadFile.class.getClassLoader().getResource("").getPath();
            System.out.println(path);
            File file = new File(path+"/js/test.js");
            FileInputStream in = new FileInputStream(file);
            InputStreamReader bf = new InputStreamReader(in);
            BufferedReader read = new BufferedReader(bf);
            String line = null;
            while((line = read.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
