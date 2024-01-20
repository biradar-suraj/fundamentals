package org.drogo.basics.patterns;

import org.drogo.basics.oop.Singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonViolation implements Serializable, Cloneable {
    private static SingletonViolation soleInstance;

    private SingletonViolation() {
        System.out.println("Creating");
    }

    //Lazy initialization
    public static SingletonViolation getInstance() {
        if (soleInstance == null) {
            soleInstance = new SingletonViolation();
        }
        return soleInstance;

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, IOException,
            CloneNotSupportedException {
        /*SingletonViolation s1 = SingletonViolation.getInstance();
        SingletonViolation s2 = SingletonViolation.getInstance();

        System.out.println("s1: " + s1.hashCode());
        System.out.println("s2: " + s2.hashCode());*/

        /*
            Reflection API
            Serialization/Deserialization
            Clone
            Multi-threaded access
            Multiple class loaders
            Garbage collection
        */



        //Reflection
        /*Class<?> aClass = Class.forName("org.drogo.basics.patterns.SingletonViolation");
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        SingletonViolation s3 = (SingletonViolation) declaredConstructor.newInstance();
        System.out.println("s3: " +s3.hashCode());*/

        //Serialization
        /*ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("/tmp/s2.ser"));
        oos.writeObject(s2);

        ObjectInputStream ois= new ObjectInputStream(new FileInputStream("/tmp/s2.ser"));
        SingletonDP s4 = (SingletonDP) ois.readObject();

        System.out.println("s4: "+s4.hashCode());*/


        //Clone
       /* SingletonViolation s5= (SingletonViolation) s2.clone();
        System.out.println("s5: "+s5.hashCode());*/

        //Multithreading
        ExecutorService service= Executors.newFixedThreadPool(2);
        service.submit(Test::useSingleton);
        service.submit(Test::useSingleton);
        service.shutdown();
    }

    private static void useSingleton() {
        SingletonViolation singleton= SingletonViolation.getInstance();
        System.out.println("singleton: "+singleton.hashCode());
    }
}
