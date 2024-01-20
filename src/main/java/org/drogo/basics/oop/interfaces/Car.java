package org.drogo.basics.oop.interfaces;

public class Car implements Engine, Brake{
    @Override
    public void brake() {
        System.out.println("This car brakes like a normal car");
    }

    @Override
    public void start() {
        System.out.println("This car starts like a normal car");
    }

    @Override
    public void stop() {
        System.out.println("This car stops like a normal car");
    }

    @Override
    public void accelerate() {
        System.out.println("This car accelerates like a normal car");
    }
}
