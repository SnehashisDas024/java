//Leetcode Problem 744: Find Smallest Letter Greater Than Target
// https:// leetcode.com/problems/find-smallest-letter-greater-than-target/
//Not exactly correct, misinterpreted the question

import java.util.Scanner;
public class Q5 {
    public char nextGreatestLetter(char[] letters, char target){
        int l=0,u=letters.length;
        int mid;
        while (l<=u){
            mid=l+(u-l)/2;
            if (letters[mid] == target){
                return letters[mid];
            }
            else if (letters[mid]>target)
                u=mid-1;
            else
                l=mid+1;
        }
        return letters[u];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read character array input
        System.out.print("Enter letters (space-separated): ");
        String[] input = scanner.nextLine().split(" ");
        char[] letters = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            letters[i] = input[i].charAt(0);
        }

        // Read target character
        System.out.print("Enter target character: ");
        char target = scanner.nextLine().charAt(0);

        // Call your method and show result
        Q5 ob = new Q5();
        char result = ob.nextGreatestLetter(letters, target);
        System.out.println("Result: " + result);
        scanner.close();
    }
}

