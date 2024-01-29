package org.drogo.basics.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class HashMapImpl<K, V> {

    private ArrayList<LinkedList<Entity>> list;
    private int size = 0;
    private float loadFactor = 0.5f;

    public HashMapImpl(int initialCapacity) {
        list = new ArrayList<>(Collections.nCopies(initialCapacity, null));
    }

    private class Entity {
        K key;
        V value;

        public Entity(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode() % list.size());
    }

    private void put(K key, V value) {
        int hash = getHash(key);
        LinkedList<Entity> entities = list.get(hash);

        if (entities == null) {
            entities = new LinkedList<>();
            list.set(hash, entities);
        }

        for (Entity entity :
                entities) {
            if (entity.key.equals(key)) {
                entity.value = value;
                return;
            }
        }

        entities.add(new Entity(key, value));
        size++;

        if ((float) size / list.size() > loadFactor) {
            reHash();
        }
    }

    private void reHash() {
        System.out.println("Rehashing");
        ArrayList<LinkedList<Entity>> oldList = list;
        list = new ArrayList<>(Collections.nCopies(oldList.size() * 2, null));
        size = 0;

        for (LinkedList<Entity> entities :
                list) {
            if (entities != null) {
                for (Entity entry :
                        entities) {
                    put(entry.key, entry.value);
                }
            }
        }
    }


    public V get(K key) {
        int hash = getHash(key);
        LinkedList<Entity> entities = list.get(hash);

        if (entities != null) {
            for (Entity entity :
                    entities) {
                if (entity.key.equals(key)) {
                    return entity.value;
                }
            }
        }

        return null;
    }

    public void remove(K key) {
        int hash = getHash(key);
        LinkedList<Entity> entities = list.get(hash);
        Entity target = null;
        if (entities != null) {
            for (Entity entity :
                    entities) {
                if (entity.key.equals(key)) {
                    target = entity;
                    break;
                }
            }

            entities.remove(target);
            size--;


        }
    }

    public boolean containsKey(K key) {

        return get(key) != null;
    }


}
