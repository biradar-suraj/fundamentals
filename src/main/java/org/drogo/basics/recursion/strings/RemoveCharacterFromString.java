package org.drogo.basics.recursion.strings;

public class RemoveCharacterFromString {

    public static void removeA(String input, String output) {
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }

        char ch = input.charAt(0);

        if (ch == 'a') {
            removeA(input.substring(1), output);
        } else {
            removeA(input.substring(1), output + ch);
        }


    }

    public static String skipA(String input) {
        String output;
        if (input.isEmpty()) {
            return "";
        }

        char ch = input.charAt(0);

        if (ch == 'a') {
            output = skipA(input.substring(1));
        } else {
            output = ch + skipA(input.substring(1));
        }

        return output;


    }

    public static void main(String[] args) {
        String str = "baccdah";
        removeA(str, "");
        System.out.println(skipA(str));
    }

}
