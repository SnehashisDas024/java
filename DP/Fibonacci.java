
import java.util.*;

class Fibonacci {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the term you want: ");
    int n = sc.nextInt();
    Fibonacci ob = new Fibonacci();
    System.out.println("The fibonacci term is: " + ob.fib(n));
    sc.close();
  }

  // Recursion + memoization
  public int fib(int n) {
    int[] dp = new int[n + 1];
    return fibo(n, dp);
  }

  public int fibo(int n, int[] dp) {
    if (n <= 1)
      return n;
    if (dp[n] != 0)
      return dp[n];
    int ans = fibo(n - 1, dp) + fibo(n - 2, dp);
    dp[n] = ans;
    return ans;
  }

  // Tabulation method
  public int fibb(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }
}
