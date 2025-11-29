//Leetcode Problem 74: https://leetcode.com/problems/search-a-2d-matrix/  Difficulty: Medium
// Tags: Array, Binary Search


import java.util.Scanner;

public class Q8 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int l = 0, u = rows * cols - 1;
        while (l <= u) {
            int mid = l + (u - l) / 2;
            if (matrix[mid / cols][mid % cols] == target) {
                return true;
            } else if (matrix[mid / 2][mid % 2] > target) {
                u = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of rows: ");
    int m = sc.nextInt();
    System.out.print("Enter number of columns: ");
    int n = sc.nextInt();

    int[][] matrix = new int[m][n];
    System.out.println("Enter matrix elements row by row:");
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            matrix[i][j] = sc.nextInt();
        }
    }

    System.out.print("Enter target value: ");
    int target = sc.nextInt();

    Q8 solver = new Q8();
    boolean found = solver.searchMatrix(matrix, target);
    System.out.println("Target found: " + found);
    sc.close();
}
}
