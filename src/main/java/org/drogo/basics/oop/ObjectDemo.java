package org.drogo.basics.oop;

public class ObjectDemo {

    int num;
    float gpa;

    public ObjectDemo(int num, float gpa) {
        this.num = num;
        this.gpa = gpa;
    }

    public ObjectDemo() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public static void main(String[] args) {
        ObjectDemo object1= new ObjectDemo(34,56.8f);
        ObjectDemo object2= new ObjectDemo(12,78.6f);

        if(object1 == object2){
            System.out.println("Both objects are equal");
        }

        if(object1.equals(object2)){
            System.out.println("Both objects are equal");
        }
    }
}
