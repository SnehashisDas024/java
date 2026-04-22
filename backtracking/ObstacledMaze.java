import java.util.*;

// Rules: 
// i. 0 is an obstacle. Cannot pass through 0
// ii. Any other non zero number can be passed through

class ObstacledMaze {
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

    if (arr[r][c] == 0) {
      System.out.println("Starting point is blocked!");
      sc.close();
      return;
    }
    ObstacledMaze ob = new ObstacledMaze();
    ArrayList<String> result = ob.pathstoEnd(arr, r, c, "");
    System.out.println("The paths that lead from given point to the end is: " + result);
    sc.close();
  }

  public ArrayList<String> pathstoEnd(int[][] arr, int row, int col, String p) {
    if (row == arr.length - 1 && col == arr[0].length - 1) {
      ArrayList<String> takeThis = new ArrayList<>();
      takeThis.add(p);
      return takeThis;
    }
    ArrayList<String> down = new ArrayList<>();
    ArrayList<String> right = new ArrayList<>();
    if (row < arr.length - 1 && arr[row + 1][col] != 0) {
      down = pathstoEnd(arr, row + 1, col, p + "D");
    }
    if (col < arr[0].length - 1 && arr[row][col + 1] != 0) {
      right = pathstoEnd(arr, row, col + 1, p + "R");
    }
    // if (!down.isEmpty()) {
    // down.addAll(right);
    // return down;
    // } else
    // return right;
    ArrayList<String> result = new ArrayList<>();
    result.addAll(down);
    result.addAll(right);
    return result;
  }
}
