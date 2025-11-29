import java.util.Arrays;
import java.util.Scanner;
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers");
        int a[]= new int[3];
        for (int i = 0; i < 3; i++) {
            a[i]=sc.nextInt();
        }
        Arrays.sort(a);
        System.out.println("The largest number is: " + a[2]);
        System.out.println("The smallest number is: " + a[0]);
        sc.close();
    }
    
}
