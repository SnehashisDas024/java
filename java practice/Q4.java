//Leetcode Problem 852: Peak Index in a Mountain Array
// https://leetcode.com/problems/peak-index-in-a-mountain-array/

import java.util.Scanner;
public class Q4 {
    public static int MountainPeak(int arr[]){
        int l=0,u=arr.length-1;
        while (l<=u){
            int mid= l+(u-l)/2;
            if (arr[mid]>arr[mid+1]){
                if (arr[mid]>arr[mid-1])
                    return mid;
                else
                    u=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;
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
        int ans = MountainPeak(num);
        System.out.println("The index of the index element is: "+ans);
        sc.close();
    }
}
