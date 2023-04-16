package com.kisick.framework.register;

import com.kisick.framework.URL;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 模拟注册中心
 */
public class RemoteMapRegister {


    private static Map<String, List<URL>> map = new HashMap<>();

    public static void register(String interfaceName, URL url) {
        map.compute(interfaceName, (k, v) -> {
            if (v == null) {
                v = new ArrayList<>();
            }
            v.add(url);
            return v;
        });

        saveToFile();
    }

    public static List<URL> get(String interfaceName) {
        map = (Map<String, List<URL>>) getFromFile();
        return map.get(interfaceName);
    }

    public static void saveToFile() {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("/tmp/temp.txt");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(map);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static Object getFromFile() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("/tmp/temp.txt");
            ObjectInputStream objectOutputStream = new ObjectInputStream(fileInputStream);
            Object object = objectOutputStream.readObject();
            return object;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
