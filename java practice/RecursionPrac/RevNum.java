import java.util.Scanner;

public class RevNum {
    static int count = 0;
    static int reverse(int n) {
        if (n == 0){
            return count;
        }
        else {
            if (n % 10 == 0)
                count++;
            return reverse(n / 10);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        System.out.println("The number of zeroes is: " + reverse(n));
        sc.close();
    }
}