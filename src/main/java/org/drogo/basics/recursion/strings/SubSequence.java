package org.drogo.basics.recursion.strings;

import java.util.ArrayList;

public class SubSequence {
    static void subSeq(String input, String output) {
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }
        char ch = input.charAt(0);

        subSeq(input.substring(1), output + ch);
        subSeq(input.substring(1), output);
    }

    static ArrayList<String> subSequence(String input, String output) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (input.isEmpty()) {
            arrayList.add(output);
            return arrayList;
        }
        char ch = input.charAt(0);

        ArrayList<String> left = subSequence(input.substring(1), output + ch);
        ArrayList<String> right = subSequence(input.substring(1), output);

        arrayList.addAll(left);
        arrayList.addAll(right);
        return arrayList;
    }

    static ArrayList<String> subSequenceAscii(String input, String output) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (input.isEmpty()) {
            arrayList.add(output);
            return arrayList;
        }
        char ch = input.charAt(0);

        ArrayList<String> left = subSequenceAscii(input.substring(1), output + ch);
        ArrayList<String> right = subSequenceAscii(input.substring(1), output);
        ArrayList<String> ascii = subSequenceAscii(input.substring(1), output + (ch + 0));


        arrayList.addAll(left);
        arrayList.addAll(right);
        arrayList.addAll(ascii);
        return arrayList;
    }

    public static void main(String[] args) {
        subSeq("abc", "");
        ArrayList<String> arrayList = subSequenceAscii("abc", "");
        System.out.println(arrayList);
    }
}
