import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
  public static void main(String[] args) {
    DailyTemperature sol = new DailyTemperature();

    int[] temperatures1 = { 73, 74, 75, 71, 69, 72, 76, 73 };
    int[] result1 = sol.dailyTemperatures(temperatures1);
    System.out.println("Test Case 1: " + Arrays.toString(result1)); // Expected: [1, 1, 4, 2, 1, 1, 0, 0]

    int[] temperatures2 = { 30, 40, 50, 60 };
    int[] result2 = sol.dailyTemperatures(temperatures2);
    System.out.println("Test Case 2: " + Arrays.toString(result2)); // Expected: [1, 1, 1, 0]
  }

  public int[] dailyTemperatures(int[] arr) {
    return arr; // Random return. This is incomplete
  }

  public static int[] nextGreater(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int[] result = new int[arr.length];

    for (int i = arr.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= arr[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        result[i] = 0;
      } else {
        result[i] = stack.peek();
      }
      stack.push(arr[i]);
    }
    return result;
  }
}
