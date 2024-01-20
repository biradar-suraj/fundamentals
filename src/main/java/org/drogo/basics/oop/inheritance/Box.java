package org.drogo.basics.oop.inheritance;

public class Box {
    double h;
    double l;
    double w;

    public Box(double h, double l, double w) {
        this.h = h;
        this.l = l;
        this.w = w;
    }

    Box(){
        this.l=-1;
        this.h=-1;
        this.w=-1;
    }

    Box(double side){
        this.h=side;
        this.l=side;
        this.w=side;
    }

    Box(Box oldBox){
        this.h=oldBox.h;
        this.l=oldBox.l;
        this.w=oldBox.w;
    }
}
