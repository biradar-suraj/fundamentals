package org.drogo.basics.strings;

public class Palindrome {
    public static void main(String[] args) {
        String str="Malayalam";
        System.out.println(isPalindrome(str));

    }

    static boolean isPalindrome(String string){
        if(string==null || string.isEmpty()) {
            return true;
        }
         string = string.toLowerCase();
        for (int i = 0; i <= string.length()/2; i++) {
            char start= string.charAt(i);
            char end= string.charAt(string.length()-1-i);

            if(start!=end) return false;
        }

        return true;
    }
}
