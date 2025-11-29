import java.util.Stack;

public class MinStack {
  // Approach 1: using O(1) time and O(N) extra space
  // Use for interview rounds
  Stack<Integer> stack = new Stack<>();
  Stack<Integer> min = new Stack<>();

  public void push(int val) {
    stack.push(val);
    if (min.isEmpty())
      min.push(val);
    else {
      if (val < min.peek()) {
        min.push(val);
      } else {
        min.push(min.peek());
      }
    }
  }

  public void pop() {
    stack.pop();
    min.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return min.peek();
  }
}
