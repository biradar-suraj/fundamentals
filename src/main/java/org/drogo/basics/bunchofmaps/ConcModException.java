package org.drogo.basics.bunchofmaps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ConcModException {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("player1", 4);
        scores.put("player2", 6);
        scores.put("player3", 4);
        scores.put("player4", 2);
        scores.put("player5", 4);
        scores.put("player6", 6);
        scores.put("player7", 6);
        scores.put("player8", 0);
        scores.put("player9", 4);

        Iterator<String> playerIterator = scores.keySet().iterator();
        while (playerIterator.hasNext()) {
            System.out.println(scores.get(playerIterator.next())); // ConcurrentModificationException
            scores.put("player10", 8);
        }
    }
}
