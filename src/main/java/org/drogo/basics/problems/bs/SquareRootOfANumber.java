package org.drogo.basics.problems.bs;

/*  69. Sqrt(x)
*   https://leetcode.com/problems/sqrtx/description/
* */
public class SquareRootOfANumber {

    static int findSquareRoot(int x){
        int start=1;
        int end= (x/2)+1;
        long mid=0;

        while(start<=end){
            mid= start+(end-start)/2;

            if(mid*mid==x){
                return (int) mid;
            }
            if(x < mid*mid){
                end= (int) (mid-1);
            }else{
                start= (int) (mid+1);
            }
        }
        return end;
    }

    public static void main(String[] args) {
        System.out.println(findSquareRoot(64));
    }
}
