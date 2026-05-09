import java.util.*;

class Count1Submatrices {
  public static void main(String[] args) {
    int[][] matrix = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
    int result = countSquares(matrix);
    System.out.println("Total square submatrices with all ones: " + result);
  }

  public static int countSquares(int[][] matrix) {
    int r = matrix.length;
    int c = matrix[0].length;
    int[][] dp = new int[r][c];
    int sum = 0;

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {

        if (matrix[i][j] == 1) {
          if (i == 0 || j == 0) {
            dp[i][j] = 1;
          } else {
            dp[i][j] = 1 + Math.min(dp[i - 1][j],
                Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
          }
        } else {
          dp[i][j] = 0;
        }

        sum += dp[i][j];
      }
    }

    return sum;
  }
}
