import java.util.Arrays;
import java.util.Scanner;

public class MaxMinrec {
    static boolean isFirstCall = true;
    static int[] a = new int[2];
    public int[] MaxMin(int[] arr, int length){
        if (isFirstCall){
            a = new int[]{arr[0], arr[0]};
            isFirstCall = false;
        }

        if (length == 1){
            return a;
        }
        else{
            a[0] = Math.max(a[0], arr[length]);
            a[1] = Math.min(a[1], arr[length]);
            return MaxMin(arr, length-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        MaxMinrec ob = new MaxMinrec();
        System.out.println("{Max, Min}");
        System.out.println(Arrays.toString(ob.MaxMin(arr, n-1)));
        sc.close();
    }
}
