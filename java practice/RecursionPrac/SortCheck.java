import java.util.Scanner;

public class SortCheck {
    public boolean isSorted(int[] arr, int n, int i){
        if (i < n-2 && arr[i] <= arr[i + 1])
            return isSorted(arr, n, i + 1);
        else if (i == n - 2 && arr[i] <= arr[i + 1])
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Array to check if it is sorted or not(5 elements): ");
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++)
            arr[i] = sc.nextInt();
        SortCheck ob = new SortCheck();
        System.out.println(ob.isSorted(arr, arr.length, 0));
        sc.close();
    }
}
