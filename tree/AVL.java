import java.util.Scanner;

public class AVL {
  public class Node {
    int value;
    Node left;
    Node right;
    int height;

    public Node(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
      this.height = -1;
    }
  }

  private Node root;

  public int height(Node node) {
    if (node == null) {
      return -1;
    }
    return node.height;
  }

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
    // node.height = Math.max(node.left.height, node.right.height) + 1;
    int leftH = (node.left == null) ? -1 : node.left.height;
    int rightH = (node.right == null) ? -1 : node.right.height;
    node.height = Math.max(leftH, rightH) + 1;

    return rotate(node);
  }

  public Node rotate(Node node) {
    // Left heavy
    if ((height(node.left) - height(node.right)) > 1) {
      // Left-left
      if (height(node.left.left) > height(node.left.right)) {
        return rightRotate(node);
      }
      // Left-right
      else {
        node.left = leftRotate(node.left);
        return rightRotate(node);
      }
    }
    // Right heavy
    if ((height(node.left) - height(node.right)) < -1) {
      // Right-right
      if (height(node.right.right) > height(node.right.left)) {
        return leftRotate(node);
      }
      // Right-left
      else {
        node.right = rightRotate(node.right);
        return leftRotate(node);
      }
    }
    return node;
  }

  public Node rightRotate(Node node) {
    Node c = node.left;
    Node p = node;

    p.left = c.right;
    c.right = p;

    p.height = Math.max(height(p.left), height(p.right)) + 1;
    c.height = Math.max(height(c.left), height(c.right)) + 1;

    return c;
  }

  public Node leftRotate(Node node) {
    Node p = node;
    Node c = p.right;

    p.right = c.left;
    c.left = p;

    p.height = Math.max(height(p.left), height(p.right)) + 1;
    c.height = Math.max(height(c.left), height(c.right)) + 1;

    return c;
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
      System.out.println("|---->" + node.value + "(" + node.height + ")");
    } else {
      System.out.println(node.value + "(" + node.height + ")");
    }
    display(node.left, level + 1);
  }

}
