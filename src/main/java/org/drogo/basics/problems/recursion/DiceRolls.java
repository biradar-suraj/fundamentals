package org.drogo.basics.problems.recursion;

import java.util.ArrayList;
import java.util.List;

public class DiceRolls {

    static void findDiceCombinations(int input, String output) {
        if (input == 0) {
            System.out.println(output);
            return;
        }

        for (int i = 1; i <= 6 && i <= input; i++) {
            findDiceCombinations(input - i, output + i);

        }
    }

    static List<String> findDiceCombinationsList(int input, String output) {
        List<String> ansList = new ArrayList<>();
        if (input == 0) {
            ansList.add(output);
            return ansList;
        }

        for (int i = 1; i <= 6 && i <= input; i++) {
            ansList.addAll(findDiceCombinationsList(input - i, output + i));

        }
        return ansList;
    }

    static void findDiceCombinationsWithCustomFace(int input, String output, int face) {
        if (input == 0) {
            System.out.println(output);
            return;
        }

        for (int i = 1; i <= face && i <= input; i++) {
            findDiceCombinationsWithCustomFace(input - i, output + i, face);

        }
    }

    static List<String> findDiceCombinationsWithCustomFaceList(int input, String output, int face) {
        List<String> ansList = new ArrayList<>();
        if (input == 0) {
            ansList.add(output);
            return ansList;
        }

        for (int i = 1; i <= face && i <= input; i++) {
            ansList.addAll(findDiceCombinationsWithCustomFaceList(input - i, output + i, face));

        }
        return ansList;
    }


    public static void main(String[] args) {
        findDiceCombinations(2, "");
        System.out.println(findDiceCombinationsList(2, ""));
        findDiceCombinationsWithCustomFace(6,"",8);
        System.out.println(findDiceCombinationsWithCustomFaceList(6,"",8));
    }
}
