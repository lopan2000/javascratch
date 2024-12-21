package designpatterns.singleton;

import java.io.*;

public class Main {

    private static final String PATH = "./src/designpatterns/singleton/";

    public static void main(String[] args) {

        //testGetInstancesAreSame();
        testSerializeDeserialize();
    }

    /*
    note, same instance in both cases
     */
    private static void testGetInstancesAreSame() {
        MySingleton o1 = MySingleton.getInstance();
        System.out.println(o1);
        MySingleton o2 = MySingleton.getInstance();
        System.out.println(o2);
    }

    private static void testSerializeDeserialize() {
        MySingleton o1 = MySingleton.getInstance();
        System.out.println(o1);
        String filename = "mysingleton.ser";
        serialize(o1, filename);
        MySingleton o2 = deserialize(filename);
        System.out.println(o2);
    }

    private static void serialize(MySingleton mySingleton, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(PATH + filename))) {
            oos.writeObject(mySingleton);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static MySingleton deserialize(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(PATH + filename))) {
            return (MySingleton) ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}