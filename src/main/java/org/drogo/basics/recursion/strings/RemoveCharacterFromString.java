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

    public static String skipApple(String input) {
        String output;
        if (input.isEmpty()) {
            return "";
        }

        if (input.startsWith("apple")) {
            output = skipApple(input.substring(5));
        } else {
            output = input.charAt(0) + skipApple(input.substring(1));
        }

        return output;


    }

    public static String skipAppNotApple(String input) {
        String output;
        if (input.isEmpty()) {
            return "";
        }

        if (input.startsWith("app")&& !input.startsWith("apple")) {
            output = skipAppNotApple(input.substring(3));
        } else {
            output = input.charAt(0) + skipAppNotApple(input.substring(1));
        }

        return output;


    }

    public static void main(String[] args) {
        String str = "bappleccdah";
        removeA(str, "");
        String outputSkipA=skipA(str);
        System.out.println(outputSkipA);
        String outputSkipApple = skipApple(str);
        System.out.println(outputSkipApple);
    }

}
