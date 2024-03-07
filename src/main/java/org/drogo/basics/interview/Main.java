package org.drogo.basics.interview;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*   Given an Array List . Find all the even number , do their square and perform addition:
          list= [2,4,7,3,9,2]
          Expected Result:   4+16+4=24
*/
public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2, 4, 7, 3, 9, 2);

        Integer sumOfEvenNumbers = nums.stream()
                .filter(num -> num % 2 == 0)
                .map(num -> num * num)
                .reduce(0, Integer::sum);

        System.out.println(sumOfEvenNumbers);

        Map<Employee, Long> hashmap= new HashMap<>();
        hashmap.put(new Employee(1,"Suraj"),1L);
        hashmap.put(new Employee(2,"Deep"),2L);
        hashmap.put(new Employee(1,"Sushil"),3L);
        hashmap.put(new Employee(1,"Krishna"),4L);
        hashmap.put(new Employee(1,"Suraj"),1L);

    }
}
