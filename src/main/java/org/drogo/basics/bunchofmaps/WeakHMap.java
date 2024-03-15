package org.drogo.basics.bunchofmaps;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHMap {
    public static void main(String[] args) {
        Map<Order, Integer> orders = new WeakHashMap<>();

        orders.put(new Order(1, "electronics"), 100);
        orders.put(new Order(2, "books"), 200);

        Order o3 = new Order(3, "kitchen");
        orders.put(o3, 300);
        System.out.println(orders.size());

        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(orders.size());


    }
}

class Order {
    int orderId;
    String details;

    public Order(int orderId, String details) {
        this.orderId = orderId;
        this.details = details;
    }
}
