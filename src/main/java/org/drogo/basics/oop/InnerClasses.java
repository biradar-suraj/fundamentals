package org.drogo.basics.oop;

public class InnerClasses {

    static class Test{
        String name;

        public Test(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Test a = new Test("Suraj");
        Test b= new Test("Rahul");
        System.out.println(a);
        System.out.println(a.name);
        System.out.println(b.name);

    }


}

 class Test{
    static String name;

    public Test(String name) {
        Test.name = name;
    }
}

/*Outer classes can not be static
static class A {

}*/
