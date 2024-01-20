package org.drogo.basics.collection;

import java.util.*;

public class IteratorBasics {

    public static void main(String[] args) {

        // Obtaining the iterator
        List<String> list= new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        Iterator<String> iterator1 = list.iterator();

        iterator1.forEachRemaining(System.out::println);

        while (iterator1.hasNext()){
            String next = iterator1.next();
            System.out.println(next);
        }

        // ListIterator Bidirectional iterator
        ListIterator<String> stringListIterator = list.listIterator();
        while (stringListIterator.hasNext()){
            System.out.println(stringListIterator.next());

        }

        while(stringListIterator.hasPrevious()){
            System.out.println(stringListIterator.previous());

        }



        Set<String> set= new HashSet<>();
       set.add("one");
       set.add("two");
       set.add("three");

        Iterator<String> iterator2 = set.iterator();

        // Modification during iteration ConcurrentModificationException
        while (iterator2.hasNext()){
            String next = iterator2.next();

            if(next.equals("two")){
                set.add("four");
            }

            if(next.equals("three")){
                iterator2.remove();
            }
        }

    }
}
