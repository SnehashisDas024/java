// Stock Span Question
// Present in GFG

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
  public static void main(String[] args) {
    int[] inputArray = { 100, 80, 60, 70, 60, 75, 85 };
    int[] ans = checkSpan(inputArray);
    System.out.println(Arrays.toString(ans));
  }

  public static int[] checkSpan(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    // stack.add(0);
    int[] result = new int[arr.length];
    for (int i = 0; i < result.length; i++)
      result[i] = 1;
    for (int i = 0; i < arr.length; i++) {
      if (stack.isEmpty() || arr[stack.peek()] > arr[i]) {
        stack.push(i);
      } else {
        while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
          result[i] += result[stack.peek()];
          stack.pop();
        }
        stack.push(i);
      }
    }
    return result;
  }
}

// Another method of calculating the span

// public static int[] checkSpan(int[] arr) {
// Stack<Integer> stack = new Stack<>();
// int[] result = new int[arr.length];
//
// for (int i = 0; i < arr.length; i++) {
// // Pop smaller or equal prices
// while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
// stack.pop();
// }
//
// // If stack is empty, it means all previous prices are smaller
// if (stack.isEmpty()) {
// result[i] = i + 1;
// } else {
// // Otherwise, span is distance between current and last higher price
// result[i] = i - stack.peek();
// }
//
// // Push current index
// stack.push(i);
// }
//
// return result;
// }
