package org.drogo.basics.functionalinterface;

@FunctionalInterface
public interface InterfaceB extends InterfaceA {

    // we can not have multiple abstract methods
    // int execute(int a, int b);
}
