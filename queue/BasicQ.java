import java.util.LinkedList;
import java.util.Queue;

public class BasicQ {
  public static void main(String[] args) {
    Queue<Integer> que = new LinkedList<>();
    que.add(25);
    que.add(26);
    que.add(27);
    que.add(28);
    que.add(29);
    que.add(30);
    System.out.println(que);
    Queue<Integer> helper = new LinkedList<>();
    while (!que.isEmpty()) {
      System.out.print(que.peek() + " -> ");
      helper.add(que.remove());
    }
    System.out.println("END");
    System.out.println(helper);
  }
}
