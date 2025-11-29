import java.util.Scanner;

public class ValPerfSqr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        ValPerfSqr ob = new ValPerfSqr();
        if(ob.isPerfectSquare(n))
            System.out.println("Perfect Square");
        else
            System.out.println("Not a perfect square");
        sc.close();
    }
    
    public boolean isPerfectSquare(int num){
        int l = 0, u = num/2;
        while (l <= u){
            int mid = l + (u-l)/2;
            int squ = mid * mid;
            if (squ == num){
                return true;
            }
            else if (squ > num)
                u = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }
}
