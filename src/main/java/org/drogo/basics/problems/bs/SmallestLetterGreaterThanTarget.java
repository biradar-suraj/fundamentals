package org.drogo.basics.problems.bs;

public class SmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
            char[] letters={'c','d','f','j'};
            char target='j';
        System.out.println(nextGreatestLetter(letters, target));
    }

    private static char nextGreatestLetter(char[] letters, char target){
        int start= 0;
        int end= letters.length-1;

        while(start<=end){
            int midIndex= start+(end-start)/2;
            int midChar= letters[midIndex];

            if(target<midChar){
                end= midIndex-1;
            }else{
                start= midIndex+1;
            }
        }
        return letters[start%letters.length];
    }
}
