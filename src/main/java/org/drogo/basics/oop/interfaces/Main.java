package org.drogo.basics.oop.interfaces;

public class Main {

    public static void main(String[] args) {
        /*Car car= new Car();
        car.accelerate();
        car.start();
        car.stop();*/

        NiceCar niceCar= new NiceCar();
        niceCar.start();
        niceCar.playMusic();

        niceCar.upgradeEngine();
        niceCar.start();

    }
}
