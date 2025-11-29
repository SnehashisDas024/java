/** This is my approach of searching in a 2D array(matrix). 
 * Given: The array is sorted row-wise and column-wise, i.e., the rows are increasing and the columns as well.
 * Here, the logic is that I check the range(the specific row or column; in this case, the column) in the matrix where the target value may be present. Then the specific value is searched in the limited space using binary search.
 * Time complexity: O(n*log n)
 */

import java.util.Arrays;
import java.util.Scanner;

public class ArraySearchTest {
    
    public int[] ArraySearch(int arr[][], int target){
        int n = arr.length;
        int[] a = new int[2];
        a[0]=-1;
        a[1]=-1;
        for ( int j = 0 ; j < n ; j++ ){
            if ( arr[0][j] <= target && target <= arr[n-1][j] )
            {
                int l = 0,u = n-1;
                while(l <= u){
                    int mid = l + (u-l)/2;
                    if (arr[mid][j] == target){
                        a[0] = mid;
                        a[1] = j;
                        return a;
                    }
                    else if(arr[mid][j] > target){
                        u = mid - 1;
                    }
                    else{
                        l = mid + 1;
                    }
                }
            }
            else{
                continue;
            }
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        ArraySearchTest ob = new ArraySearchTest();
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
 