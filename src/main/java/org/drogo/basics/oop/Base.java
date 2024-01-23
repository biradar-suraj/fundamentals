package org.drogo.basics.oop;

public class Base {
    static {
        System.out.println("Static block of Base class");
    }
    {
        System.out.println("Normal block of Base class");
    }

    public Base() {
        System.out.println("Constructor of Base class");
    }
}

class Sub extends Base{
    static {
        System.out.println("Static block of Sub class");
    }
    {
        System.out.println("Normal block of Sub class");
    }

    public Sub() {
        System.out.println("Constructor of Sub class");
    }
}

class BaseSub {
    public static void main(String[] args) {
        Sub sub= new Sub();
    }

}
