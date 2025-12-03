import java.util.Arrays;

public class Q493 {
  public static void main(String[] args) {
    Q493 sol = new Q493();

    int[][] tests = {
        {1, 3, 2, 3, 1},   // Expected: 2
        {2, 4, 3, 5, 1},   // Expected: 3
        {5, 4, 3, 2, 1},   // Expected: 4
        {1, 2, 3, 4},      // Expected: 0
        {2147483647, 2147483647, 2147483647, 2147483647}, // Expected: 0
        {2147483647, 2147483647, -2147483647, -2147483647} // Edge case with negatives
    };

    for (int[] test : tests) {
        System.out.println("Input: " + Arrays.toString(test));
        System.out.println("Reverse Pairs = " + sol.reversePairs(test));
        System.out.println();
    }
  }
  static int result = 0;
    public int reversePairs(int[] nums) {
        long[] arr = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        result = 0;
        return mergeSort(arr, 0, arr.length - 1);
    }
  public static int mergeSort(long[] arr, int low, int high) {
    if (low < high) {
      int mid = low + (high - low) / 2;
      mergeSort(arr, low, mid);
      mergeSort(arr, mid + 1, high);
      merge(arr, low, mid, high);
    }
    return result;
  }
  public static int merge(long[] arr, int low, int mid, int high) {
    long[] a = new long[high - low + 1];
    int i = low, j = mid + 1, k = 0;
        while (i <=mid && j <=high) {
            if (arr[i] > (2 * arr[j])) {
                result += (mid - i + 1);
                j++;
            } else  i++;
        }
        i = low;
        j = mid + 1;
    while (i <=mid && j <=high) {
      if (arr[i] <= arr[j]) {
        a[k++] = arr[i++];
      }
            else {
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

}