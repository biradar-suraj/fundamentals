package org.drogo.basics.oop;

public class Main {

    public static void main(String[] args) {

       /* Student student1= new Student();

        System.out.println(student1.name);

        Human suraj= new Human(30,"Suraj Biradar",10000,false);
        Human rahul= new Human(29,"Rahul D",15000,false);
        System.out.println(suraj);
        System.out.println(rahul);
        System.out.println(Human.population);*/

        Main funn= new Main();
        funn.fun2();

        Singleton singleton= Singleton.getInstance();

    }

    static void fun(){

        //greeting(); can not be accessed because it requires an instance but static function we are using does not depend on instance
        // non-static stuff can not be accessed without referencing their instance in a static context

        Main obj = new Main();
        obj.greeting();
    }

    void fun2(){
        greeting();
    }

    void greeting(){
        System.out.println("Hello world");
    }
}

class Student{
    int rollNumber;
    String name;
    float marks;

    Student(){
       this(1,"Default Name",00.0f);
    }

    Student(int rollNumber,String name,float marks){
        this.rollNumber= rollNumber;
        this.name= name;
        this.marks=marks;

    }
}
