package org.drogo.basics.oop.cloning;

public class Person implements Cloneable {

    int age;
    String name;
    int[] arr;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
        this.arr= new int[]{3,5,6,8,9,1};
    }

    @Override
    public Person clone() {
        try {
            //This is shallow copy
            Person clone = (Person) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original

            // Deep copy
            clone.arr = new int[clone.arr.length];
            System.arraycopy(this.arr, 0, clone.arr, 0, clone.arr.length);

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
