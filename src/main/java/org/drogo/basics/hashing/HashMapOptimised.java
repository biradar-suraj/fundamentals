package org.drogo.basics.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class HashMapOptimised<K, V> {

    private ArrayList<LinkedList<MapEntity>> list;
    private int size = 0;

    public HashMapOptimised() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new LinkedList<>());
        }
    }

    public HashMapOptimised(int initialCapacity) {
        list = new ArrayList<>(Collections.nCopies(initialCapacity, null));
    }

    public void put(K key, V value) {
        int hash = Math.abs(key.hashCode() % list.size());

        LinkedList<MapEntity> entities = list.get(hash);
        if (entities == null) {
            entities = new LinkedList<>();
            list.set(hash, entities);
        }

        for (MapEntity entity :
                entities) {
            if (entity.key.equals(key)) {
                entity.value = value;
                return;
            }
        }

        entities.add(new MapEntity(key, value));
        size++;


        float laodFactor = 0.5f;

        if ((float) size / list.size() > laodFactor) {
            reHash();
        }
    }

    private void reHash() {
        System.out.println("Rehashing");
        ArrayList<LinkedList<MapEntity>> old = list;

        list = new ArrayList<>(Collections.nCopies(old.size() * 2, null));
        size = 0;

        for (LinkedList<MapEntity> entities :
                list) {
            if (entities != null) {
                for (MapEntity entry :
                        entities) {
                    put(entry.key, entry.value);
                }
            }

        }
    }

    public V get(K key) {
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<MapEntity> entities = list.get(hash);

        if (entities != null) {
            for (MapEntity entry :
                    entities) {
                if (entry.key.equals(key)) return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<MapEntity> entities = list.get(hash);

        MapEntity target = null;
        if (entities != null) {
            for (MapEntity entity :
                    entities) {
                if (entity.key.equals(key)) {
                    target = entity;
                    break;
                }
            }
        }

        if (target != null) {
            entities.remove(target);
            size--;
        }

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");

        for (LinkedList<MapEntity> entities :
                list) {
            for (MapEntity entity :
                    entities) {
                builder.append(entity.key);
                builder.append("=");
                builder.append(entity.value);
                builder.append(",");
            }
        }
        builder.append("}");
        return builder.toString();
    }

    private class MapEntity {
        K key;
        V value;

        MapEntity(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
