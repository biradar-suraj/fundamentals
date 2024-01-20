package org.drogo.basics.designpatterns.builder;

public class Pizza {
    private String size;
    private boolean isVeg;
    private String topping;
    private String base;
    private String sauce;
    private boolean extraCondiments;

    private Pizza(PizzaBuilder pizzaBuilder){


    }

    public String getSize() {
        return size;
    }

    public boolean isVeg() {
        return isVeg;
    }

    public String getTopping() {
        return topping;
    }

    public String getBase() {
        return base;
    }

    public String getSauce() {
        return sauce;
    }

    public boolean isExtraCondiments() {
        return extraCondiments;
    }

    private class PizzaBuilder {
    }
}
