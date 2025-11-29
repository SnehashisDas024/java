

import java.util.Arrays;
import java.util.Scanner;

public class SumTriangle {
    public void printTri(int arr[]){
        int len = arr.length;
        if (len == 1)
        {
            System.out.println(Arrays.toString(arr));
            return;
        }
        else{
            int[] arr2 = new int[len-1];
            for (int i = 0; i < len - 1; i++){
                arr2[i] = arr[i] + arr[i + 1];
            }
            printTri(arr2);
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements in the array: ");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        SumTriangle ob = new SumTriangle();
        ob.printTri(arr);
        sc.close();
    }
}
