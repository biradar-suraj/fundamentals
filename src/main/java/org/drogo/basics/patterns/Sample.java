package org.drogo.basics.patterns;

import java.util.function.Function;

public class Sample {
    public static void main(String[] args) {
        //Function
        Function<Integer,Integer> increment= number -> number+1;
        print(5,"incremented",increment);
        print(6,"incremented",increment);

        Function<Integer,Integer> doubleIt= number -> number*2;
        print(5,"doubled",doubleIt);
        print(6,"doubled", doubleIt);

        //.andThen()
        Function<Integer, Integer> incrementAndDoubleIt = increment.andThen(doubleIt);
        print(5,"incremented and doubled",incrementAndDoubleIt);

    }

    public static void print(int number, String message, Function<Integer,Integer> func){

        System.out.println(number+" "+message+": " +func.apply(number));
    }
}
