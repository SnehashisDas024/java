// Every item has unlimited capacity

import java.util.Arrays;

public class UnboundedKnapsack {
  public static void main(String[] args) {
    int[] val = { 6, 3, 7, 25 };
    int[] wt = { 2, 2, 8, 9 };
    int c = 9;
    int n = wt.length;
    int[][] dp = new int[n][c + 1];
    for (int i = 0; i < dp.length; i++)
      Arrays.fill(dp[0], -1);
    System.out.println(profit(0, wt, val, c, dp));
  }

  public static int profit(int i, int[] wt, int[] val, int target, int[][] dp) {
    if (i == wt.length)
      return 0;
    if (dp[i][target] != -1)
      return dp[i][target];
    int skip = profit(i + 1, wt, val, target, dp);
    if (wt[i] > target)
      return dp[i][target] = skip;
    int pick = val[i] + profit(i, wt, val, target - wt[i], dp);
    return dp[i][target] = Math.max(pick, skip);
  }
}
