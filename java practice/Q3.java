//Order Agnostic binary search
// Given a sorted numay in ascending or descending order
import  java.util.Scanner;
public class Q3 {
    public static int OrderAgnosticBS(int num[], int target){
        int low = 0, high=num.length-1;
        boolean isAsc = num[0] < num[high];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (num[mid] == target) {
                return mid;
            }
            if (isAsc){
                if (num[mid] < target) {
                    low = mid + 1;
                } 
                else {
                    high = mid - 1;
                }
            }
            else{
                if (num[mid] > target) {
                    low = mid + 1;
                } 
                else {
                    high = mid - 1;
                }
            }
             
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the numay:"); 
        int n = sc.nextInt();
        int[] num = new int[n]; 
        System.out.println("Enter the elements of the numay:");
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        System.out.println("Enter the target element to search:");
        int target = sc.nextInt();
        int ans = OrderAgnosticBS(num,target);
        System.out.println("The index of the target element is: "+ans);
        sc.close();
    }
}
