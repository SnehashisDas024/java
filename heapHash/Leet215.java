
import java.util.*;

class Leet215 {
  public int kthLargestElement(int[] arr, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    for (int num : arr) {
      maxHeap.add(num);
    }
    int val = 0;
    for (int i = 0; i < k; i++) {
      val = maxHeap.poll();
    }
    return val;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements in the array: ");
    int n = sc.nextInt();
    int[] arr = new int[n];
    System.out.println("Enter the array: ");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println("Enter the value of k in kth largest element of the given array: ");
    int k = sc.nextInt();
    if (k > n) {
      System.out.println("Not within array limits.");
    } else {
      Leet215 ob = new Leet215();
      int val = ob.kthLargestElement(arr, k);
      System.out.println(k + "th largest element is: " + val);
    }
    sc.close();
  }
}
