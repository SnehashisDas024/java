import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class FirstNegative {
  public static void main(String[] args) {
    // ---------- Testcase 1 ----------
    int[] arr1 = { -8, 2, 3, -6, 10 };
    int k1 = 2;
    ArrayList<Integer> res1 = firstNegInt(arr1, k1);
    System.out.println(res1);
    // Expected Output: [-8, 0, -6, -6]

    // ---------- Testcase 2 ----------
    int[] arr2 = { 12, -1, -7, 8, -15, 30, 16, 28 };
    int k2 = 3;
    ArrayList<Integer> res2 = firstNegInt(arr2, k2);
    System.out.println(res2);
    // Expected Output: [-1, -1, -7, -15, -15, 0]

    // ---------- Testcase 3 ----------
    int[] arr3 = { 1, 2, 3, 4, 5 };
    int k3 = 2;
    ArrayList<Integer> res3 = firstNegInt(arr3, k3);
    System.out.println(res3);
    // Expected Output: [0, 0, 0, 0]

    // ---------- Testcase 4 ----------
    int[] arr4 = { -5, -2, -3, -4 };
    int k4 = 2;
    ArrayList<Integer> res4 = firstNegInt(arr4, k4);
    System.out.println(res4);
    // Expected Output: [-5, -2, -3]
  }

  public static ArrayList<Integer> firstNegInt(int arr[], int k) {
    Queue<Integer> negativeList = new ArrayDeque<>();
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      if (arr[i] < 0) {
        negativeList.add(i);
      }
    }
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < n - k + 1; i++) {
      if (!negativeList.isEmpty() && negativeList.peek() < i + k) {
        while (!negativeList.isEmpty() && i > negativeList.peek()) {
          negativeList.remove();
        }
        if (negativeList.isEmpty() || negativeList.peek() >= i + k) {
          result.add(0);
        } else {
          result.add(arr[negativeList.peek()]);
        }
      } else {
        result.add(0);
      }
    }
    return result;
  }
}
