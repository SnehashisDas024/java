import java.util.Scanner;
import java.util.Arrays;

public class Bubblesort {
    public void bubblesort(int arr[]){
        for (int i=0;i<=arr.length;i++){
            for (int j=0;j<arr.length-1-i;j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bubblesort ob = new Bubblesort();
        System.out.println("Enter the number of elements of the array");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n;i++)
            a[i] = sc.nextInt();
        ob.bubblesort(a);
        System.out.println(Arrays.toString(a));
        sc.close();
    }
}
