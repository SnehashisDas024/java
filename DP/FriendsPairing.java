
import java.util.*;

class FriendsPairing {
  public static void main(String[] args) {
    // int n = 4; // try changing this value
    System.out.println("Enter a number");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    FriendsPairing ob = new FriendsPairing();
    System.out.println("Number of ways for " + n + " friends = " + ob.countWays(n));
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    ob.countWaysrec(n, dp);
    System.out.println("Value from recursion: " + dp[n]);
    sc.close();
  }

  public int countWays(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i < n + 1; i++) {
      dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
    }
    return dp[n];
  }

  public int countWaysrec(int n, int[] dp) {
    if (n < 0)
      return 0;
    if (n == 0 || n == 1) {
      return dp[n] = 1;
    }
    if (dp[n] != -1) {
      return dp[n];
    } else {
      return dp[n] = countWaysrec(n - 1, dp) + (n - 1) * countWaysrec(n - 2, dp);
    }
  }
}
