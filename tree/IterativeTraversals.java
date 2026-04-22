
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class IterativeTraversals {

  // ============================
  // Node Structure
  // ============================
  static class Node {
    int value;
    Node left, right;
    int height;

    Node(int value) {
      this.value = value;
    }
  }

  // ROOT IS STATIC
  public static Node root;

  // ============================
  // Build Tree From Array
  // ============================
  public void buildTreeFromArray(Integer[] arr) {
    if (arr == null || arr.length == 0) {
      root = null;
      return;
    }

    root = new Node(arr[0]);
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);

    int i = 1;
    while (!queue.isEmpty() && i < arr.length) {
      Node current = queue.poll();

      // left child
      if (i < arr.length && arr[i] != null) {
        current.left = new Node(arr[i]);
        queue.offer(current.left);
      }
      i++;

      // right child
      if (i < arr.length && arr[i] != null) {
        current.right = new Node(arr[i]);
        queue.offer(current.right);
      }
      i++;
    }

    updateHeights(root);
  }

  private int updateHeights(Node node) {
    if (node == null)
      return -1;
    int lh = updateHeights(node.left);
    int rh = updateHeights(node.right);
    node.height = Math.max(lh, rh) + 1;
    return node.height;
  }

  // ============================
  // Display Function
  // ============================
  public void display() {
    display(root, 0);
  }

  private void display(Node node, int level) {
    if (node == null)
      return;

    display(node.right, level + 1);

    if (level != 0) {
      for (int i = 0; i < level - 1; i++) {
        System.out.print("|\t");
      }
      System.out.println("|----> " + node.value + " (h=" + node.height + ")");
    } else {
      System.out.println(node.value + " (h=" + node.height + ")");
    }

    display(node.left, level + 1);
  }

  // ============================
  // Traversals (You Write)
  // ============================
  public List<Integer> inorderIterative(Node root) {
    List<Integer> inorder = new ArrayList<>();
    if (root == null)
      return inorder;

    Stack<Node> stack = new Stack<>();
    Node curr = root;

    while (!stack.empty() || curr != null) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      inorder.add(curr.value);
      curr = curr.right;
    }
    return inorder;
  }

  public List<Integer> preorderIterative() {
    List<Integer> preorder = new ArrayList<>();
    if (root == null)
      return preorder;

    Stack<Node> stack = new Stack<>();
    Node curr = root;

    while (!stack.empty() || curr != null) {
      while (curr != null) {
        preorder.add(curr.value);
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      curr = curr.right;
    }
    return preorder;
  }

  public List<Integer> postorderIterative() {
    List<Integer> postorder = new ArrayList<>();
    if (root == null)
      return postorder;

    Stack<Node> stack = new Stack<>();
    Node curr = root;
    Node lastVisited = null;

    while (!stack.empty() || curr != null) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.peek();
      if (curr.right != null && lastVisited != curr.right) {
        curr = curr.right;
      } else {
        postorder.add(curr.value);
        lastVisited = stack.pop();
        curr = null;
      }
    }
    return postorder;
  }

  // ============================
  // MAIN + Scanner Input
  // ============================
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    IterativeTraversals tree = new IterativeTraversals();

    System.out.print("Enter number of elements: ");
    int n = sc.nextInt();

    Integer[] arr = new Integer[n];
    System.out.println("Enter " + n + " integers (-1 for null):");

    // Sample Input: 8 6 7 2 -1 -1 3 4 5 6

    for (int i = 0; i < n; i++) {
      int x = sc.nextInt();
      if (x == -1)
        arr[i] = null;
      else
        arr[i] = x;
    }

    tree.buildTreeFromArray(arr);

    System.out.println("\nTree Structure:");
    tree.display();

    // after you write your traversal code:
    List<Integer> result = tree.inorderIterative(root);
    System.out.println("\nInorder:   " + result);
    System.out.println("Preorder:  " + tree.preorderIterative());
    System.out.println("Postorder: " + tree.postorderIterative());
    sc.close();
  }
}
