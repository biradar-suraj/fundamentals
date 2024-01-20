package org.drogo.basics.hashing;

public class Main {
    public static void main(String[] args) {
        MapUsingHash map= new MapUsingHash();

        map.put("Mango", "King of fruits");
        map.put("Apple", "Sweet red fruit");
        map.put("Kiwi", "Oval Chinese gooseberry");

        System.out.println(map.get("Apple"));


        HashMapFinal<String,String> hashMap= new HashMapFinal<>(5);
        hashMap.put("Mango", "King of fruits");
        hashMap.put("Apple","Sweet red fruit");
        hashMap.put("Kiwi","Oval gooseberry");

        System.out.println(hashMap.get("Mango"));

        System.out.println(hashMap);

        hashMap.remove("Kiwi");
        System.out.println(hashMap);
        System.out.println(hashMap.containsKey("Mango"));

    }
}
