package org.drogo.basics.multithreading;

/* StringBuilder results in a race condition when multiple thread operate on it
 *  Use StringBuffer to resolve this as the operations are synchronised*/
public class StringBuilderAndBuffer {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                stringBuilder.append("S");
                stringBuffer.append("S");
            }
            System.out.println("Thread t1 completed");
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                stringBuilder.append("B");
                stringBuffer.append("B");
            }
            System.out.println("Thread t2 completed");
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("StringBuilder length: " + stringBuilder.toString().length());
        System.out.println("StringBuffer length: " + stringBuffer.toString().length());


    }
}
