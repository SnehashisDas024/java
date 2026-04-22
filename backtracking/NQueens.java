import java.util.*;

public class NQueens {
  /*
   * Input:
   * n (integer) → size of the chessboard (n x n)
   * Example: n = 4
   *
   * Output:
   * List of all valid board configurations
   * Each configuration is a List<String> where:
   * - 'Q' represents a queen
   * - '.' represents an empty space
   *
   * Example Output for n = 4:
   * [
   * [".Q..",
   * "...Q",
   * "Q...",
   * "..Q."],
   *
   * ["..Q.",
   * "Q...",
   * "...Q",
   * ".Q.."]
   * ]
   */

  public static void main(String[] args) {
    NQueens sol = new NQueens();

    int n = 4; // You can change this value
    List<List<String>> result = sol.solveNQueens(n);

    // Printing the solutions
    for (List<String> board : result) {
      for (String row : board) {
        System.out.println(row);
      }
      System.out.println(); // separate each solution
    }
  }

  public boolean leftdiagonal(int[][] board, int row, int col) {
    --row;
    --col;
    while (row >= 0 && col >= 0) {
      if (board[row][col] != 0)
        return false;
      row--;
      col--;
    }
    return true;
  }

  public boolean rightdiagonal(int[][] board, int row, int col) {
    --row;
    ++col;
    while (row >= 0 && col <= board[0].length - 1) {
      if (board[row][col] != 0)
        return false;
      row--;
      col++;
    }
    return true;
  }

  public boolean lookUpwards(int[][] board, int row, int col) {
    --row;
    while (row >= 0) {
      if (board[row][col] != 0)
        return false;
      row--;
    }
    return true;
  }

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<>();
    int[][] board = new int[n][n];
    solveNqin(n, board, 0, result);
    return result;
  }

  public void solveNqin(int n, int[][] board, int row, List<List<String>> result) {
    if (row == n) {
      List<String> temp = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        String p = "";
        for (int j = 0; j < n; j++) {
          if (board[i][j] == 1) {
            p = p + "Q";
          } else {
            p = p + ".";
          }
        }
        temp.add(p);
      }
      result.add(temp);
      return;
    } else {
      for (int i = 0; i < n; i++) {
        boolean ld = leftdiagonal(board, row, i);
        boolean rd = rightdiagonal(board, row, i);
        boolean lp = lookUpwards(board, row, i);
        if (ld && rd && lp) {
          board[row][i] = 1;
          // nq++;
          solveNqin(n, board, row + 1, result); // Cannot understand how to know if this was a failure. Maybe
                                                // we want the loop to go on and on. But it will result in all
                                                // cols in the 1st row.
                                                // Understood. There is the loop that goes on through all the answers
                                                // possible and only add the ones necessary
          board[row][i] = 0;
        }
        // boolean ld = leftdiagonal(board, row, col);
        // boolean rd = rightdiagonal(board, row, col);
        // boolean lp = lookUpwards(board, row, col);
        // if (col == board[2].length - 1)
        // return;
        // else if (ld && rd && lp) {
        // board[row][col] = 1;
        // nq++;
        // }
      }
    }
  }
}
