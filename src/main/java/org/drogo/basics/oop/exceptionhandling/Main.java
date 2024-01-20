package org.drogo.basics.oop.exceptionhandling;

public class Main {
    public static void main(String[] args) {

        int a = 5;
        int b = 0;
        try {
            //int result = divide(a, b);
            customException("Suraj");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int divide(int a, int b) throws ArithmeticException{
        if(b==0){
            throw new ArithmeticException("Do not divide by 0");
        }
        return a/b;

    }

    public static void customException(String name) throws MyException {
        if(name.equals("Suraj")){
            throw new MyException("Name is Suraj");
        }
    }
}
