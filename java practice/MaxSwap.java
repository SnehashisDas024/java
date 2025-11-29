//Leetcode problem 670: https://leetcode.com/problems/maximum-swap/  Difficulty: Medium
// Tags: Greedy, String

import java.util.Scanner;
public class MaxSwap {
    public static int mSwap(int n){
        //String s = Integer.toString(n);
        int[] digits = String.valueOf(Math.abs(n)).chars().map(c -> c - '0').toArray();
        int maxz = digits.length-1; //MAX no. of 0
        for (int i=0; i<maxz; i++){
            if (digits[i] < digits[i+1]){
                int t = digits[i];
                digits[i] = digits[i+1];
                digits[i+1] = t;
                break;                
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int d : digits)
            sb.append(d);
        n = Integer.parseInt(sb.toString());
        return n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int ans = mSwap(n);
        System.out.println("The max version of the entered  number is: "+ans);
        sc.close();
    }
}