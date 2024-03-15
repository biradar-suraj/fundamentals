package org.drogo.basics.bunchofmaps;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ConcurrentHMap {
    static Map<String, Long> orders = new ConcurrentHashMap<>();
    static Map<String, AtomicLong> atomicOrders = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        orders.put("Mumbai", 0L);
        orders.put("Beijing", 0L);
        orders.put("New York", 0L);
        orders.put("London", 0L);

        atomicOrders.put("Mumbai", new AtomicLong());
        atomicOrders.put("Beijing", new AtomicLong());
        atomicOrders.put("London", new AtomicLong());
        atomicOrders.put("New York", new AtomicLong());

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(ConcurrentHMap::processOrders);
        service.submit(ConcurrentHMap::processOrders);

        service.awaitTermination(1, TimeUnit.SECONDS);
        service.shutdown();

        System.out.println(orders);
        System.out.println(atomicOrders);

    }

    private static void processOrders() {
        for (String city : orders.keySet()) {
            /* non-atomic operations */
            for (int i = 0; i < 50; i++) {
                Long oldOrder = orders.get(city);
                orders.put(city, oldOrder + 1);
            }
        }

        for (String city : atomicOrders.keySet()) {
            /* atomic operations */
            for (int i = 0; i < 50; i++) {
                atomicOrders.get(city).getAndIncrement();
            }
        }
    }
}
