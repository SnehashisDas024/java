
import java.util.*;

class Leet2146 {
  public static void main(String[] args) {
    Solution sol = new Solution();

    int[][] grid = {
        { 1, 2, 0, 1 },
        { 1, 3, 0, 1 },
        { 0, 2, 5, 1 }
    };
    int[] pricing = { 2, 5 };
    int[] start = { 0, 0 };
    int k = 3;

    List<List<Integer>> result = sol.highestRankedItems(grid, pricing, start, k);
    System.out.println(result);
    // Expected output: [[0,1],[1,1],[2,1]]
  }

  public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
    Queue<Integer> queue = new ArrayDeque<>();
    int i, j;

  }
}
