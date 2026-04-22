
import java.util.*;

class ClimbingStairs {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of stairs: ");
    int n = sc.nextInt();
    int[] dp = new int[n + 1];
    ClimbingStairs ob = new ClimbingStairs();
    sc.close();
    // System.out.println("The number of ways to climb is: " +
    // ob.countRecursive(n));
    System.out.println("The number of ways to climb is: " + ob.countDP(n, dp));
  }

  public int countRecursive(int n) {
    if (n < 0) {
      return 0;
    } else if (n == 0) {
      return 1;
    } else {
      return countRecursive(n - 1) + countRecursive(n - 2);
    }
  }

  public int countDP(int n, int[] dp) {
    if (n < 0) {
      return 0;
    } else if (dp[n] != 0) {
      return dp[n];
    } else if (n == 0) {
      return 1;
    } else {
      int ans = countDP(n - 1, dp) + countDP(n - 2, dp);
      dp[n] = ans;
      return ans;
    }
  }
}
