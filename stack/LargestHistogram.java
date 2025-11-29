import java.util.Stack;

public class LargestHistogram {
  public static void main(String[] args) {
    LargestHistogram sol = new LargestHistogram();

    int[] heights1 = { 2, 1, 5, 6, 2, 3 };
    int result1 = sol.largestRectangleArea(heights1);
    System.out.println("Test Case 1: " + result1); // Expected: 10

    int[] heights2 = { 2, 4 };
    int result2 = sol.largestRectangleArea(heights2);
    System.out.println("Test Case 2: " + result2); // Expected: 4
  }

  public int largestRectangleArea(int[] heights) {
    int[] prevArray = previousSmaller(heights);
    int[] nextArray = nextSmaller(heights);
    int maxArea = -1;
    for (int i = 0; i < heights.length; i++) {
      int area = heights[i] * (prevArray[i] + nextArray[i] - 1);
      maxArea = Math.max(maxArea, area);
    }
    return maxArea;
  }

  public static int[] previousSmaller(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int[] result = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        result[i] = i + 1;
      } else {
        result[i] = i - stack.peek();
      }
      stack.push(i);
    }
    return result;
  }

  public static int[] nextSmaller(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int[] result = new int[arr.length];
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
