import java.util.Stack;

public class NSE {
  public static void main(String[] args) {
    int[] inputArray = { 100, 80, 60, 70, 60, 75, 85 };
    int[] result = nextSmaller(inputArray);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + " ");
    }
  }

  public static int[] nextSmaller(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int[] result = new int[arr.length];
    // Arrays.fill(result, 1);
    int n = arr.length;

    for (int i = arr.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        result[i] = n - i;
      } else {
        result[i] = stack.peek() - i;
      }
      stack.push(i);
    }
    return result;
  }
}
