import java.util.LinkedList;
import java.util.Queue;

public class InbuiltExamples {
  public static void main(String[] args) {
    // Stack<Integer> stack = new Stack<>();
    //
    // stack.push(25);
    // stack.push(25);
    // stack.push(25);
    // stack.push(25);
    // stack.push(25);
    // stack.push(25);
    // stack.push(25);
    //
    // System.out.println(stack);
    //
    // System.out.println(stack.pop());
    // System.out.println(stack.pop());
    // System.out.println(stack.pop());
    // System.out.println(stack.pop());
    // System.out.println(stack.pop());
    // System.out.println(stack.pop());
    // System.out.println(stack.pop());

    Queue<Integer> queue = new LinkedList<>();

    queue.add(54);
    queue.add(78);
    queue.add(51);
    queue.add(21);
    queue.add(44);
    queue.add(98);
    queue.add(65);
    queue.add(554);

    System.out.println(queue);
    System.out.println(queue.remove());
    System.out.println(queue.remove());
    System.out.println(queue.remove());
    System.out.println(queue.remove());
    System.out.println(queue);

  }
}
