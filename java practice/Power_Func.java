import java.util.Scanner;

public class Power_Func{
    public int calcPow(int a, int pow){
        
        if (pow == 0)
            return 1;
        else if (pow == 1)
            return a;
        else
            return a*calcPow(a, pow - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the base number and the power");
        int n = sc.nextInt();
        int p = sc.nextInt();
        Power_Func ob = new Power_Func();        
        int ans = ob.calcPow(n,p);
        System.out.println("The result is: "+ans);
        sc.close();
    }
}