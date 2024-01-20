package org.drogo.basics.exception;

import org.drogo.basics.exception.AgeLessThanZeroException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class CustomException {
    public static void main(String[] args) throws AgeLessThanZeroException {
        validateAge(-1);


    }

    private static void validateAge(int age) throws AgeLessThanZeroException {
        if(age<0){
            throw new AgeLessThanZeroException("Age can not be negative", new RuntimeException());

        }
    }
}