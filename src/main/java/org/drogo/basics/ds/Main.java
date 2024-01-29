package org.drogo.basics.ds;

public class Main {
    public static void main(String[] args) {

       /* MyLinkedList linkedList= new MyLinkedList();
        linkedList.insertFirst(3);
        linkedList.insertFirst(5);
        linkedList.insertFirst(8);
        linkedList.insertFirst(9);

        linkedList.display();

        linkedList.insertLast(99);
        linkedList.display();
        linkedList.insert(100,3);
        linkedList.display();*//*

        MyLL linkedList= new MyLL();
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(7);
        linkedList.display();
        linkedList.insertLast(9);
        linkedList.insertLast(13);
        linkedList.insertLast(11);
        linkedList.display();

        linkedList.reverse();
        linkedList.display();

        linkedList.insertAt(6,3);
        linkedList.display();

        linkedList.deleteLast();
        //linkedList.deleteFirst();

        linkedList.display();
        linkedList.deleteFirst();
        linkedList.display();*/



        int[] ints = {-9, 14, 37, 102};
        System.out.println(exists(ints, 102)); // true
        System.out.println(exists(ints, 36)); // false



    }

    static boolean exists(int[] ints, int k){
        boolean found = false;
        for (int a:
             ints) {
            if(k==a){
               found=true;
                break;
            }
            
        }
        return found;
    }

    static int closestToZero(int[] ts){
        if(ts.length==0) return 0;
        int minAbs= Integer.MAX_VALUE;
        int closestToZero = 0;

        for (int i = 0; i < ts.length; i++) {
            int abs= Math.abs(ts[i]);
            if(abs<minAbs) {
                minAbs = abs;
                closestToZero = ts[i];
            } else if (abs==minAbs) {
                closestToZero=Math.abs(closestToZero);
                
            }
        }
        return closestToZero;
    }
}
