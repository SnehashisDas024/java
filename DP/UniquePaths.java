
import java.util.*;

class UniquePaths {
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(dp[i], -1);
    }
    return countPaths(0, 0, dp);
  }

  public int countPaths(int r, int c, int[][] dp) {
    if ((r == dp.length - 1) || (c == dp[0].length - 1))
      return dp[r][c] = 1;
    if (dp[r][c] != -1) {
      return dp[r][c];
    } else {
      int down = countPaths(r + 1, c, dp);
      int right = countPaths(r, c + 1, dp);
      return dp[r][c] = down + right;
    }
  }

  public int tabulation(int r, int c) {
    int[][] dp = new int[r][c];
    for (int i = 0; i < r; i++) {
      dp[i][c - 1] = 1;
    }
    for (int i = 0; i < c; i++) {
      dp[r - 1][i] = 1;
    }
    for (int i = r - 2; i >= 0; i--) {
      for (int j = c - 2; j >= 0; j--) {
        dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
      }
    }
    return dp[0][0];
  }

  public static void main(String[] args) {
    UniquePaths ob = new UniquePaths();
    int result = ob.uniquePaths(3, 7);
    int tab_res = ob.tabulation(3, 7);
    System.out.println(tab_res);
    System.out.println(result);
  }
}
