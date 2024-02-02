package org.drogo.basics.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionAPI {
    public static void main(String[] args) throws Exception {
        CompanyModel company = new CompanyModel("Suraj Inc");
        System.out.println("Company name: " + company.getName());

        Field name = CompanyModel.class.getDeclaredField("name");
        name.setAccessible(true);
        name.set(company, "Google");
        System.out.println("Company name: " + company.getName());

        Method displayMethod = CompanyModel.class.getDeclaredMethod("displayName");
        displayMethod.setAccessible(true);
        displayMethod.invoke(company);


    }
}
