package org.drogo.basics.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringJoiner;

public class HashMapFinal<K, V> {

    private ArrayList<LinkedList<Entity>> list;
    private int size = 0;

    public HashMapFinal(int initialCapacity) {
        list = new ArrayList<>(Collections.nCopies(initialCapacity, null));
    }

    public void put(K key, V value) {
        int hash = Math.abs(key.hashCode() % list.size());

        LinkedList<Entity> entities = list.get(hash);
        if (entities == null) {
            entities = new LinkedList<>();
            list.set(hash, entities);
        }
        for (Entity entity : entities) {
            if (entity.key.equals(key)) {
                entity.value = value;
                return;
            }
        }
        entities.add(new Entity(key, value));
        size++;

        float loadFactor = 0.5f;
        if ((float) size / list.size() > loadFactor) {
            reHash();
        }
    }

    private void reHash() {
        System.out.println("Rehashing");
        ArrayList<LinkedList<Entity>> old = list;

        list = new ArrayList<>(Collections.nCopies(old.size() * 2, null));
        size = 0;

        for (LinkedList<Entity> entities : old) {
            if (entities != null) {
                for (Entity entry : entities) {
                    put(entry.key, entry.value);
                }
            }
        }
    }

    public V get(K key) {
        int hash = Math.abs(key.hashCode() % list.size());

        LinkedList<Entity> entities = list.get(hash);
        if (entities != null) {
            for (Entity entity : entities) {
                if (entity.key.equals(key)) return entity.value;
            }
        }
        return null;
    }

    public void remove(K key){
        int hash= Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);

        Entity target = null;
        if(entities!=null){
            for (Entity entry :
                    entities) {
                if (entry.key.equals(key)){
                    target = entry;
                    break;
                }
            }

            entities.remove(target);
            size--;
        }




    }

    public boolean containsKey(K key){
        return get(key)!=null;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "{", "}");
        for (LinkedList<Entity> entities : list) {
            if (entities != null) {
                for (Entity entry : entities) {
                    sj.add(entry.key + "=" + entry.value);
                }
            }
        }
        return sj.toString();
    }



    private class Entity {
        K key;
        V value;

        Entity(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

