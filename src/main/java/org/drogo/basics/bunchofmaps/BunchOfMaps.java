package org.drogo.basics.bunchofmaps;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class BunchOfMaps {
    public static void main(String[] args) {
        /* All methods are thread-safe, synchronized keyword on each public method */
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();

        /* Not thread-safe, need to use synchronized operations when manipulating from multiple threads
           Iteration is not guaranteed in insertion order */
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        /*  Similar to HashMap, iteration is guaranteed in insertion order
            Maintains separate doubly linked list */
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();

        /*  Implementation of SortedMap and NavigableMap interfaces
            Iteration is guaranteed in natural sorted order of keys
            Red-black tree based implementation */
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        /* Uses identity to store and retrieve key values
           Uses reference equality, r1==r2 rather than r1.equals(r2)
           Memory footprint is smaller than HashMap*/
        IdentityHashMap<Integer, Integer> identityHashMap = new IdentityHashMap<>();

        /* Null keys are not permitted. Not synchronised
           Iterator does not fail-fast */
        EnumMap<Month, Integer> enumMap = new EnumMap<>(Month.class);
        EnumMap<Day, String> dayEnumMap = new EnumMap<>(Day.class);

        /* Elements in a WeakHashmap can be reclaimed by the GC
           if there are no other strong references to the object,
           this makes them useful for caches/lookup storage */
        WeakHashMap<String, Integer> weakHashMap = new WeakHashMap<>();

        /* A convenient decorator to create fully synchronized map
           Feel free not to use it! */
        Collections.synchronizedMap(hashMap);

        /*  Full concurrency during retrieval
            Reads can happen fast, while writes require a lock
            Write lock is acquired at granular level, whole table is not locked
            only segments(16) are locked
            Iterations do not throw concurrent modification exception
            Operations not atomic */
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        /*  A scalable concurrent ConcurrentNavigableMap/SortedMap imp
            Equivalent of TreeMap in concurrent world
            Guarantees average O(log n) performance on a wide variety of operations
            ConcurrentHashMap does not guarantee operation time as part of its contract */
        ConcurrentSkipListMap<String, Integer> concurrentSkipListMap = new ConcurrentSkipListMap<>();
    }
}
