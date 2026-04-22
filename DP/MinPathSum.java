
import java.util.*;

class MinPathSum {
  public static void main(String[] args) {
    MinPathSum ob = new MinPathSum();
    // Case 1: Smallest grid (edge case)
    int[][] grid1 = {
        { 5 }
    };
    System.out.println(ob.minPathSum(grid1)); // Expected: 5

    // Case 2: Simple 2x2 grid
    int[][] grid2 = {
        { 1, 2 },
        { 1, 1 }
    };
    System.out.println(ob.minPathSum(grid2)); // Expected: 3 (path: 1→1→1)

    // Case 3: Standard 3x3 grid
    int[][] grid3 = {
        { 1, 3, 1 },
        { 1, 5, 1 },
        { 4, 2, 1 }
    };
    System.out.println(ob.minPathSum(grid3)); // Expected: 7 (path: 1→3→1→1→1)

    // Case 4: Larger 4x3 grid with varied values
    int[][] grid4 = {
        { 1, 2, 5 },
        { 3, 2, 1 },
        { 4, 3, 1 },
        { 5, 6, 1 }
    };
    System.out.println(ob.minPathSum(grid4)); // Expected: 8 (path: 1→2→2→1→1→1)
  }

  public int minPathSum(int[][] grid) {
    int r = grid.length, c = grid[0].length;
    int[][] dp = new int[r][c];
    for (int i = 0; i < r; i++) {
      Arrays.fill(dp[i], -1);
    }
    fillPathSum(0, 0, grid, dp);
    return dp[0][0];
  }

  public int fillPathSum(int r, int c, int[][] grid, int[][] dp) {
    if (r > grid.length - 1 || c > grid[0].length - 1)
      return -1;
    if (dp[r][c] != -1)
      return dp[r][c];
    else {
      int down = fillPathSum(r + 1, c, grid, dp);
      int right = fillPathSum(r, c + 1, grid, dp);
      int res;
      if (down == -1 && right == -1)
        res = 0;
      else if (down == -1)
        res = right;
      else if (right == -1)
        res = down;
      else
        res = Math.min(down, right);
      return dp[r][c] = grid[r][c] + res;
    }
  }

  public int minps(int[][] grid) {
    int r = grid.length, c = grid[0].length;
    int[][] dp = new int[r][c];
    for (int i = r - 1; i >= 0; i--) {
      for (int j = c - 1; j >= 0; j--) {
        if (i == r - 1 && j == c - 1) {
          dp[i][j] = grid[i][j];
        } else 
      }
    }
  }
}
