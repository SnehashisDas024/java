
import java.util.*;

class CountDerangements {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number n: ");
    int n = sc.nextInt();
    CountDerangements ob = new CountDerangements();
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    dp[1] = 0;
    dp[2] = 1;
    System.out.println("The number of derangements is: " + ob.count(n, dp));
    sc.close();
  }

  public int count(int n, int[] dp) {
    if (n < 1) {
      return dp[n];
    }
    if (dp[n] != -1)
      return dp[n];
    else
      return dp[n] = (n - 1) * (count(n - 1, dp) + count(n - 2, dp));
  }
}
