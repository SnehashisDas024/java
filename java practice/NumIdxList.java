import java.util.ArrayList;
import java.util.Scanner;

public class NumIdxList {
    // Using Loop
    // public ArrayList<Integer> numIndex(int[] arr, int target, int n, ArrayList<Integer> list){
    //     for (int i = 0; i < n; i++){
    //         if (arr[i] == target) {
    //             list.add(i);
    //         }
    //     }
    //     return list;
    // }
    // Using Recursion - 1
    // public ArrayList<Integer> numIndex(int[] arr, int target, int n, ArrayList<Integer> list) {
    //     if (n == arr.length){
    //         return list;
    //     }
    //     else{
    //         if (arr[n] == target) {
    //             list.add(n);
    //         }
    //         return numIndex(arr, target, ++n, list);
    //     }
    // }
    //Using Recursion - 2
    public ArrayList<Integer> numIndex(int[] arr, int target, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        if (n == arr.length) {
            return list;
        }
        if (arr[n] == target) {
            list.add(n);
        }
        ArrayList<Integer> previousOnes = numIndex(arr, target, ++n);
        list.addAll(previousOnes);
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements in the array: ");
        int[] arr = new int[6];
        for(int i = 0; i < 6; i++)  arr[i] = sc.nextInt();
        NumIdxList ob = new NumIdxList();
        // ArrayList<Integer> list = new ArrayList<>();
        // list = ob.numIndex(arr, 4, 0, list);
        // System.out.println(list);
        ArrayList<Integer> list1 = new ArrayList<>();
        list1 = ob.numIndex(arr, 4, 0);
        System.out.println(list1);
        sc.close();
    }
}
