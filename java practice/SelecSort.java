import java.util.Arrays;
import java.util.Scanner;

public class SelecSort {
    public  void selectionsort(int[] arr){
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SelecSort ob = new SelecSort();
        System.out.println("Enter the number of elements of the array");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the array: ");
        int[] a = new int[n];
        for (int i=0;i<n;i++)
            a[i] = sc.nextInt();
        ob.selectionsort(a);
        System.out.println(Arrays.toString(a));
        sc.close();
    }
    
}
