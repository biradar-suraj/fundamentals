package org.drogo.basics.memorymanagement;

import org.drogo.basics.lambda.Person;

import java.lang.ref.WeakReference;

/*  Stack Memory
    - stores temp variables and separate memory block for methods
    - stores primitive data types
    - stores reference of head objects
    - each thread has its own stack memory
    - variables that are within the SCOPE are visible, as soon as any variable goes out of the
      scope it gets removed from stack LIFO order
    - when stack memory becomes full, java.lang.StackOverflowError is thrown */

public class MemoryManagement {

    public static void main(String[] args) {
        int primitiveVariable1 = 10;
        Person personObj = new Person();
        String stringLiteral = "Suraj";
        MemoryManagement memoryObj = new MemoryManagement();
        memoryObj.memoryManagementTest(personObj);
        WeakReference<Person> weakRefPersonObj = new WeakReference<>(new Person());
    }

    private void memoryManagementTest(Person personObj) {
        Person personObj2 = personObj;
        String stringLiteral2 = "Suraj";
        String string = new String("Suraj");
    }
}
