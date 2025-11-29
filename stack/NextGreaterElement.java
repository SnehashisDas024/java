import java.util.Stack;

public class NextGreaterElement {
  public static void main(String[] args) {
    int[] inputArray = { 1, 3, 2, 1, 8, 6, 3, 4 };
    int[] result = nextGreater(inputArray);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + " ");
    }
  }

  public static int[] nextGreater(int[] arr) {
    int[] res = new int[arr.length];
    Stack<Integer> stack = new Stack<>();
    int i = arr.length - 1;
    // while (i >= 0) {
    // if (stack.isEmpty()){
    // res[i] = -1;
    // stack.push(arr[i]);
    // }
    // else if (stack.peek() > arr[i]) {
    // res[i] = stack.peek();
    // stack.push(arr[i]);
    // } else {
    // stack.pop();
    // continue;
    // }
    // i--;
    // }

    // Better method (more readable and follows the concept of monotonic stack - I
    // think)
    // Also, easy to refactor
    while (i >= 0) {
      // Remove all the smaller elements from the stack
      while (!stack.isEmpty() && stack.peek() <= arr[i]) {
        stack.pop();
      }
      // Set next greater element
      if (stack.isEmpty()) {
        res[i] = -1;
      } else {
        res[i] = stack.peek();
      }
      // Push current element for future comparisons
      stack.push(arr[i]);
      i--;
    }
    return res;
  }
}
