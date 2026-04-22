
import java.util.*;

class CountingPaths {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the dimensions of the matrix: ");
    int row = sc.nextInt();
    int col = sc.nextInt();
    int[][] arr = new int[row][col];
    System.out.println("Enter the elements: ");
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
    System.out.println("Enter the index to start from: ");
    int r = sc.nextInt();
    int c = sc.nextInt();
    CountingPaths ob = new CountingPaths();
    System.out.println("The number of paths from the given index to the end is: " + ob.countPaths(arr, r, c));
    ArrayList<String> result = ob.displayPaths(arr, r, c, "");
    System.out.println("The paths are: " + result);
    sc.close();
  }

  public int countPaths(int[][] arr, int row, int col) {
    if ((row == arr.length - 1) || (col == arr[0].length - 1)) {
      return 1;
    } else {
      return countPaths(arr, row + 1, col) + countPaths(arr, row, col + 1);
    }
  }

  public ArrayList<String> displayPaths(int[][] arr, int row, int col, String p) {
    if ((row == arr.length - 1) || (col == arr[0].length - 1)) {
      ArrayList<String> result = new ArrayList<>();
      result.add(p);
      return result;
    } else {
      ArrayList<String> down = displayPaths(arr, row + 1, col, p + "D");
      ArrayList<String> right = displayPaths(arr, row, col + 1, p + "R");
      down.addAll(right);
      return down;
    }
  }
}
