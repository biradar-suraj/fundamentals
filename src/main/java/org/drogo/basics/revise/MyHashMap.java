package org.drogo.basics.revise;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashMap<K, V> {

    private ArrayList<LinkedList<Entity>> list;
    private int size=0;
    private float loadFactor=0.5f;

    private class Entity{
        K key;
        V value;

        public Entity(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

}
