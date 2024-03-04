package org.drogo.basics.largedata;

public class StringBufferExample {
    public static void main(String[] args) {
        //constructor 1
        StringBuffer sb1 = new StringBuffer();
        //constructor 2
        StringBuffer sb2 = new StringBuffer("Suraj Biradar");
        //constructor 3
        StringBuffer sb3 = new StringBuffer(30);

        System.out.println(sb1.capacity());
        System.out.println(sb3.capacity());
        sb1.append("Suraj");
        sb1.append(" Biradar");
        System.out.println(sb1);
        sb1.insert(1, "oooooo");
        System.out.println(sb1);
        sb1.replace(1, 7, "");
        System.out.println(sb1);
        sb1.append(" Hello!");
        System.out.println(sb1);
        sb1.insert(1, "oooooo");
        System.out.println(sb1);
        sb1.delete(1, 7);
        System.out.println(sb1);

    }
}
