package org.drogo.basics.oop.interfaces;

import org.drogo.basics.oop.interfaces.Engine;

public class PetrolEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Petrol engine starts");
    }

    @Override
    public void stop() {
        System.out.println("Petrol engine stops");
    }

    @Override
    public void accelerate() {
        System.out.println("Petrol engine accelerates");
    }
}
