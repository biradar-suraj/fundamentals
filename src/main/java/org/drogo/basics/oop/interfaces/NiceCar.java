package org.drogo.basics.oop.interfaces;

public class NiceCar {

    private Engine engine;
    private Media media = new MediaPlayer();

    public NiceCar() {
        engine= new PetrolEngine();
    }

    public NiceCar(Engine engine) {
        this.engine = engine;
    }

    public void start(){
        engine.start();
    }

    public void stop(){
        engine.stop();
    }

    public void playMusic(){
        media.start();
    }

    public void upgradeEngine(){
        this.engine= new ElectricEngine();
    }
}
