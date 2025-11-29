
// import java.util.Arrays;
import java.util.Stack;

public class PSE {
  public static void main(String[] args) {
    int[] inputArray = { 100, 80, 60, 70, 60, 75, 85 };
    int[] result = previousSmaller(inputArray);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + " ");
    }
  }

  public static int[] previousSmaller(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    // int i = 1;
    int[] result = new int[arr.length];
    // Arrays.fill(result, 1);
    // while (i < arr.length) {
    // while (!stack.isEmpty() && stack.peek() > arr[i]) {
    // stack.pop();
    // }
    // if (stack.isEmpty() && i > 0) {
    // result[i] = result[i - 1];
    // } else {
    // result[i] = result[i - 1] + stack.size();
    // }
    // stack.push(arr[i]);
    // i++;
    // }
    for (int i = 0; i < arr.length; i++) {
      while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
        stack.pop();
      }
      // {
      // while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
      // result[i] += result[stack.peek()];
      // stack.pop();
      // }
      // stack.push(i);
      if (stack.isEmpty()) {
        result[i] = i + 1;
      } else {
        result[i] = i - stack.peek();
      }
      stack.push(i);
    }
    return result;
  }
}
