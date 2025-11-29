import java.util.Arrays;
import java.util.Scanner;

public class RowColMatSearch {
    public int[] ArraySearch(int arr[][], int target){
        int row = 0, col = arr[0].length - 1;
        while (row < arr.length && col >= 0){
            if (arr[row][col] == target) {
                return new int[]{row,col};
            }
            else if (arr[row][col] > target)
                col--;
            else
                row++;
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        RowColMatSearch ob = new RowColMatSearch();
        System.out.println("Enter the size of the matrix:");
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the element to search:");
        int t = sc.nextInt();
        
        System.out.println(Arrays.toString(ob.ArraySearch(a, t)));
        sc.close();
    }
}
