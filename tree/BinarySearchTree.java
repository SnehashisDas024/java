import java.util.Scanner;

public class BinarySearchTree {
  public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  private Node root;

  public void insertinBST(Scanner scanner) {
    System.out.println("Enter the value of root: ");
    int val = scanner.nextInt();
    root = new Node(val);
    insertinBST(scanner, root);
  }

  public void insertinBST(Scanner sc, Node currentNode) {
    int value = sc.nextInt();
    currentNode = goToSpot(value, currentNode);
    System.out.println("Do you want to insert again?  ");
    boolean choice = sc.nextBoolean();
    if (choice) {
      System.out.println("Enter the value: ");
      insertinBST(sc, currentNode);
    }
  }

  public Node goToSpot(int value, Node node) {
    if (node == null) {
      Node newNode = new Node(value);
      return newNode;
    } else if (value < node.value)
      node.left = goToSpot(value, node.left);
    else
      node.right = goToSpot(value, node.right);
    return node;
  }

  public void display() {
    display(root, 0);
  }

  public void display(Node node, int level) {
    if (node == null) {
      return;
    }

    display(node.right, level + 1);

    if (level != 0) {
      for (int i = 0; i < level - 1; i++) { // 0 theke start hochhe tai jekhane input hobe sekhane cursor ta niye jaoa
                                            // hochhe
        System.out.print("|\t");
      }
      System.out.println("|---->" + node.value);
    } else {
      System.out.println(node.value);
    }
    display(node.left, level + 1);
  }

  public void preorder() {
    preorder(root);
  }

  public void preorder(Node currentNode) {
    if (currentNode == null)
      return;

    System.out.print(currentNode.value + " ");
    preorder(currentNode.left);
    preorder(currentNode.right);
  }

  public void inorder() {
    inorder(root);
  }

  public void inorder(Node currentNode) {
    if (currentNode == null)
      return;

    inorder(currentNode.left);
    System.out.print(currentNode.value + " ");
    inorder(currentNode.right);
  }

  public void postorder() {
    postorder(root);
  }

  public void postorder(Node currentNode) {
    if (currentNode == null)
      return;

    postorder(currentNode.left);
    postorder(currentNode.right);
    System.out.print(currentNode.value + " ");
  }
}
