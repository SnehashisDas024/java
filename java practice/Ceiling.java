// Ceiling of a number in a given array; Ceiling -> greater than or equal to the target

import java.util.Scanner;

public class Ceiling {
    public static int Ceilingvalue(int[] arr, int target){
        int l=0,u=arr.length-1,mid=0;
        while (l<=u){
            mid=l+(u-l)/2;
            if (arr[mid] == target)
                return arr[mid];
            else if (arr[mid]>target){
                u = mid-1;
            }
            else {
                l = mid+1;
            }
        }return arr[l];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:"); 
        int n = sc.nextInt();
        int[] num = new int[n]; 
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        System.out.println("Enter the value to find: ");
        int target =  sc.nextInt();
        int ans = Ceilingvalue(num,target);
        System.out.println("The ceiling value of the given value is: "+ans);
        sc.close();
    }
}
