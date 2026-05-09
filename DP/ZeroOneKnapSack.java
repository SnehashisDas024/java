public class ZeroOneKnapSack {
  public static void main(String[] args) {
    int[] val = { 4, 8, 6, 9, 3 };
    int[] wt = { 8, 9, 4, 2, 7 };
    int c = 8;
    int[][] dp = new int[wt.length][c + 1];
    for (int i = 0; i < wt.length; i++) {
      for (int j = 0; j < c + 1; j++) {
        dp[i][j] = -1;
      }
    }
    ZeroOneKnapSack ob = new ZeroOneKnapSack();
    int result = ob.maxProfit(0, wt, val, c, dp);
    System.out.println(result);
  }

  public int maxProfit(int i, int[] wt, int[] val, int cap, int[][] dp) {
    if (i == wt.length)
      return 0;
    if (dp[i][cap] != -1)
      return dp[i][cap];
    int skip = maxProfit(i + 1, wt, val, cap, dp);
    if (wt[i] > cap)
      return dp[i][cap] = skip;
    int take = val[i] + maxProfit(i + 1, wt, val, cap - wt[i], dp);
    return dp[i][cap] = Math.max(take, skip);
  }
}
