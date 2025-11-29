import java.util.Stack;

public class RemSubsequence {
  public static int[] remove(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (stack.size() == 0 || stack.peek() != arr[i]) {
        stack.push(arr[i]);
      } else if (stack.peek() == arr[i]) {
        if (i == arr.length - 1 || arr[i] != arr[i + 1]) {
          stack.pop();
        }
      }
    }
    int[] result = new int[stack.size()];
    for (int i = stack.size() - 1; i >= 0; i--) {
      result[i] = stack.pop();
    }
    return result;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 2, 3, 10, 10, 10, 4, 7, 7, 2 };
    int[] res = remove(arr);
    for (int i = 0; i < res.length; i++) {
      System.out.print(res[i] + " ");
    }
  }
}
