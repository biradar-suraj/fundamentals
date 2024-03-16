package org.drogo.basics.streams.bingo;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamSourceChallenge {
    static int counter = 0;

    public static void main(String[] args) {
        int seed = 1;
        var streamB = Stream.iterate(seed, i -> i <= 15, i -> i + 1)
                .map(i -> "B" + i);
//        streamB.forEach(System.out::println);

        seed += 15;
        var streamI = Stream.iterate(seed, i -> i + 1)
                .limit(15)
                .map(i -> "I" + i);
//        streamI.forEach(System.out::println);

        seed += 15;
        int nSeed = seed;
        String[] oLabels = new String[15];
        Arrays.setAll(oLabels, i -> "N" + (nSeed + i));
        var streamN = Arrays.stream(oLabels);
//        streamN.forEach(System.out::println);

        seed += 15;
        var streamG = Stream.of("G46", "G47", "G48", "G49", "G50",
                "G51", "G52", "G53", "G54", "G55",
                "G56", "G57", "G58", "G59", "G60");
//        streamG.forEach(System.out::println);

        seed += 15;
        int rSeed = seed;

        var streamO = Stream.generate(StreamSourceChallenge::getCounter)
                .limit(15)
                .map(i -> "O" + (rSeed + i));
//        streamO.forEach(System.out::println);

        var streamBI = Stream.concat(streamB, streamI);
        var streamNG = Stream.concat(streamN, streamG);
        var streamBING = Stream.concat(streamBI, streamNG);
        var streamBINGO = Stream.concat(streamBING, streamO);
        streamBINGO.forEach(System.out::println);

        System.out.println("-------------------------------------------");

        Stream.iterate(rSeed, i -> i + 1)
                .limit(15)
                .map(i -> "O" + i)
                .forEach(System.out::println);

    }

    private static int getCounter() {
        return counter++;
    }


}
