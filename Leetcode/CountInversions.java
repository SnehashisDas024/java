// GFG problem. Link: https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1

import java.util.Scanner;

public class CountInversions {
	static int result = 0;
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the number of elements: ");
	    int n = sc.nextInt();
	    System.out.println("Enter the array: ");
	    int[] arr = new int[n];
	    for (int i = 0; i < n; i++) {
	    	arr[i] = sc.nextInt();	
	    }
	    int ans = inversionCount(arr);
	    System.out.println("The number of count inversions is: " + ans);
	    sc.close();
	}
	public int mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
		return result;
	}
	public int merge(int[] arr, int low, int mid, int high) {
		int[] a = new int[high - low + 1];
		int i = low, j = mid + 1, k = 0;
		while (i <=mid && j <=high) {
			if (arr[i] <= arr[j]) {
				a[k++] = arr[i++];
			} else {
				result += (mid - i + 1);
				a[k++] = arr[j++];
			}
		}
		while (i <= mid) {
			a[k++] = arr[i++];
		}
		while (j <= high) {
			a[k++] = arr[j++];
		}
		for (int c = 0; c < k; c++) {
			arr[low + c] = a[c];
		}
		return result;
	}
	public static int inversionCount(int arr[]) {
        CountInversions obj = new CountInversions();
        return obj.mergeSort(arr, 0, arr.length - 1);
    }
}