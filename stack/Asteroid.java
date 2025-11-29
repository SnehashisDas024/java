import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;

public class Asteroid {
  public static void main(String[] args) {
    Asteroid sol = new Asteroid();

    System.out.println(Arrays.toString(sol.asteroidCollision(new int[] { 5, 10, -5 }))); // [5, 10]
    System.out.println(Arrays.toString(sol.asteroidCollision(new int[] { 8, -8 }))); // []
    System.out.println(Arrays.toString(sol.asteroidCollision(new int[] { 10, 2, -5 }))); // [10]
  }

  // public int[] asteroidCollision(int[] asteroids) {
  // Stack<Integer> stack = new Stack<>();
  // ArrayList<Integer> list = new ArrayList<>();
  // for (int i = 0; i < asteroids.length; i++) {
  // if (stack.isEmpty() && asteroids[i] < 0) {
  // list.add(asteroids[i]);
  // } else if (asteroids[i] > 0) {
  // stack.push(asteroids[i]);
  // } else if (!stack.isEmpty() && asteroids[i] < 0) {
  // int val = Math.abs(asteroids[i]);
  // while (!stack.isEmpty()) {
  // if (stack.peek() < val) {
  // stack.pop();
  // } else if (stack.peek() == val) {
  // stack.pop();
  // break;
  // } else {
  // break;
  // }
  // }
  // if (stack.isEmpty())
  // list.add(asteroids[i]);
  // else {
  // while (!stack.isEmpty())
  // list.add(stack.pop());
  // }
  // }
  // }
  // while (!stack.isEmpty())
  // list.add(stack.pop());
  // int[] arr = new int[list.size()];
  // for (int i = 0; i < list.size(); i++) {
  // arr[i] = list.get(i);
  // }
  // return arr;
  // }
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < asteroids.length; i++) {
      int c = 1;
      if ((stack.isEmpty() && asteroids[i] < 0) || (!stack.isEmpty() && (asteroids[i] < 0 && stack.peek() < 0))) {
        list.add(asteroids[i]);
      } else if (asteroids[i] > 0) {
        stack.push(asteroids[i]);
      } else if (!stack.isEmpty() && asteroids[i] < 0) {
        int val = Math.abs(asteroids[i]);
        while (!stack.isEmpty()) {
          if (stack.peek() < val) {
            stack.pop();
          } else if (stack.peek() == val) {
            stack.pop();
            c = 0;
            break;
          } else {
            break;
          }
        }
        if (stack.isEmpty() && c != 0)
          list.add(asteroids[i]);
        // else {
        // Stack<Integer> stack2 = new Stack<>();
        // while (!stack.isEmpty()) {
        // stack2.push(stack.pop());
        // }
        // while (!stack2.isEmpty()) {
        // list.add(stack2.pop());
        // }
        // }
      }
    }
    Stack<Integer> stack2 = new Stack<>();
    while (!stack.isEmpty()) {
      stack2.push(stack.pop());
    }
    while (!stack2.isEmpty()) {
      list.add(stack2.pop());
    }
    int[] arr = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      arr[i] = list.get(i);
    }
    return arr;
  }
}
