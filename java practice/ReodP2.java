// // LeetCode Problem 869: Reordered Power of 2
// // Link: https://leetcode.com/problems/reordered-power-of-2/

// import java.util.Arrays;
// import java.util.Scanner;

// public class ReodP2 {
//     public boolean reorderedPowerOf2(String s, String[] strArray) {
//         int l = 0, u = strArray.length - 1;
//         boolean flag = false;
//         while (l <= u){
//             int mid = l + (u - l) / 2;
//             if (s.equals(strArray[mid])){
//                 flag = true;
//                 break;
//             }
//             else if (s.compareTo(strArray[mid]) > 0)
//                 l = mid + 1;
//             else
//                 u = mid - 1;
//         }
//         return flag;
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the number");
//         long n = sc.nextInt();
//         char[] cha = String.valueOf(n).toCharArray();
//         Arrays.sort(cha);
//         String s = new String(cha);
//         long[] arr = new long[30];
//         for (int i = 0; i < 30; i++){
//             arr[i] = (long)Math.pow(2, i);
//         }
//         String[] stringArray = new String[arr.length];
//         for (int i = 0; i < arr.length; i++) {
//             char[] digits = String.valueOf(arr[i]).toCharArray();
//             Arrays.sort(digits);
//             stringArray[i] = new String(digits);
//         }
//         ReodP2 ob = new ReodP2();
//         System.out.println(ob.reorderedPowerOf2(s, stringArray));
//     }
// }
import java.util.Arrays;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        String target = sortDigits(n);
        for (int i = 0; i < 31; i++) {
            int power = 1 << i; // 2^i
            if (target.equals(sortDigits(power))) {
                return true;
            }
        }
        return false;
    }

    private String sortDigits(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
