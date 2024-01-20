package org.drogo.basics.oop.comparison;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Student student1= new Student("Suraj",11,68.3f);
        Student student2= new Student("Ramki",5,94.54f);
        Student student3= new Student("Vinayaka",9,55.3f);
        Student student4= new Student("Sumeet",1,70.54f);
        Student student5= new Student("Gagan",7,84.3f);
        Student student6= new Student("Athirath",3,47.34f);

        Student[] list= {student1,student2,student3,student4,student5,student6};
        System.out.println(Arrays.toString(list));
        Arrays.sort(list);
        System.out.println("Sorted using comparable"+Arrays.toString(list));
        Arrays.sort(list, (o1, o2) -> (o1.rollNo-o2.rollNo));
        System.out.println("Sorted using comparator"+Arrays.toString(list));

        /*if(student1.compareTo(student2)<0){
            System.out.println("Student2 has secured more marks than Student1");

        }else {
            System.out.println("Student1 has secured more marks than Student2");
        }*/


    }
}
