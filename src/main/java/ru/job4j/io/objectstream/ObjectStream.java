package ru.job4j.io.objectstream;

import java.io.*;

public class ObjectStream {

    public static void main(String[] args) {
        Car car = new Car("Brand", "Model", 2000);
//        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/serialized.dat"))) {
//            out.writeObject(car);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/serialized.dat"));
             ObjectInputStream in = new ObjectInputStream(new FileInputStream("data/serialized.dat"))) {
            out.writeObject(car);
            Car deserialized = (Car) in.readObject();
            System.out.println(deserialized.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}