package org.drogo.basics.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class MapUsingLinkedList<K, V> {

    private ArrayList<LinkedList<Entity>> list;
    private int size=0;

    public MapUsingLinkedList() {
        list= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new LinkedList<>());
        }
    }

    public MapUsingLinkedList(int initialCapacity){
        list= new ArrayList<>(Collections.nCopies(initialCapacity,null));
    }

    public void put(K key, V value){
        int hash= Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);

        if(entities==null){
            entities= new LinkedList<>();
            list.set(hash,entities);
        }

        for (Entity entity :
                entities) {
            if (entity.key.equals(key)){
                entity.value = value;
                return;
            }
        }
         entities.add(new Entity(key, value));
        size ++;

        float loadFactor=0.5f;
        if((float) size / list.size()>loadFactor){
            reHash();

        }
    }

    private void reHash() {
        System.out.println("Rehashing");

        ArrayList<LinkedList<Entity>> oldList = list;

        list= new ArrayList<>(Collections.nCopies(oldList.size()*2,null));
        size = 0;

        for (LinkedList<Entity> entities :
                list) {
            if(entities!=null){
                for (Entity entry :
                        entities) {
                    put(entry.key, entry.value);
                }
            }
            
        }
    }
    
    
    public V get(K key){
        int hash= Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);
        
        if (entities!=null){
            for (Entity entry :
                    entities) {
                if (entry.key.equals(key)) return entry.value;
            }
        }
        return null;
    }


    @Override
    public String toString() {
         StringBuilder builder= new StringBuilder();
         builder.append("{");
        for (LinkedList<Entity> entities :
                list) {
            for (Entity entry :
                    entities) {
                builder.append(entry.key);
                builder.append("=");
                builder.append(entry.value);
                builder.append(",");
            }

        }
         builder.append("}");
        return builder.toString();
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
