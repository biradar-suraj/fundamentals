package org.drogo.basics.reflection;

public class CompanyModel {
    private String name;

    public CompanyModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void displayName() {
        System.out.println("Private Method Invoked to display Company Name: " + name);

    }
}
