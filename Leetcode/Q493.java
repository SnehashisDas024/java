package Leetcode;

import java.util.Arrays;

public class Q493 {
  public static void main(String[] args) {
    Q493 sol = new Q493();

    int[][] tests = {
        {1, 3, 2, 3, 1},   // Expected: 2
        {2, 4, 3, 5, 1},   // Expected: 3
        {5, 4, 3, 2, 1},   // Expected: 4
        {1, 2, 3, 4},      // Expected: 0
        {2147483647, 2147483647, 2147483647, 2147483647}, // Expected: 0
        {2147483647, 2147483647, -2147483647, -2147483647} // Edge case with negatives
    };

    for (int[] test : tests) {
        System.out.println("Input: " + Arrays.toString(test));
        System.out.println("Reverse Pairs = " + sol.reversePairs(test));
        System.out.println();
    }
  }
  public int reversePairs(int[] arr) {
    
  }

}