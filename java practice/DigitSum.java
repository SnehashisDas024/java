import java.util.Scanner;

public class DigitSum {
    public int calcSum(int a) {

        if (a == 0)
            return 0;
        // else if (pow == 1)
        //     return a;
        else
            return (a%10) + calcSum(a/10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the base number:");
        int n = sc.nextInt();
        DigitSum ob = new DigitSum();
        int ans = ob.calcSum(n);
        System.out.println("The result is: " + ans);
        sc.close();
    }
}