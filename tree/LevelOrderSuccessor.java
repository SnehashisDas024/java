import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderSuccessor {
  public class Node {
    int value;
    Node left;
    Node right;
    int height;

    public Node(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
      this.height = 0;
    }
  }

  public static Node root;

  // Inserts a single value into the BST
  public Node insert(Node root, int value) {
    if (root == null) {
      return new Node(value);
    }

    if (value < root.value) {
      root.left = insert(root.left, value);
    } else {
      root.right = insert(root.right, value);
    }

    int leftHeight = (root.left == null) ? -1 : root.left.height;
    int rightHeight = (root.right == null) ? -1 : root.right.height;

    root.height = Math.max(leftHeight, rightHeight) + 1;
    return root;
  }

  // Takes the array and returns the constructed tree
  public Node buildTree(int[] array) {
    Node root = null;
    for (int value : array) {
      root = insert(root, value);
    }
    return root;
  }

  public void findSuccessor(int value) {
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);
    Node result = findSuccessor(queue, value);
    if (result == null)
      System.out.println("There is no successor to this element.");
    else
      System.out.println("The successor to " + value + " is: " + result.value);
  }

  public Node findSuccessor(Queue<Node> queue, int value) {
    while (!queue.isEmpty()) {
      // Node node = queue.remove();
      if (queue.peek() == null)
        return null;
      if (queue.peek().left != null)
        queue.add(queue.peek().left);
      if (queue.peek().right != null)
        queue.add(queue.peek().right);
      if (queue.remove().value == value)
        return queue.peek();
    }
    return null;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of terms: ");
    int n = sc.nextInt();
    int[] array = new int[n];
    System.out.println("Enter the array: ");
    for (int index = 0; index < n; index++) {
      array[index] = sc.nextInt();
    }
    LevelOrderSuccessor tree = new LevelOrderSuccessor();
    root = tree.buildTree(array);
    System.out.println("Enter the element you want the level-order successor of: ");
    int val = sc.nextInt();
    tree.findSuccessor(val);
    sc.close();
  }
}
