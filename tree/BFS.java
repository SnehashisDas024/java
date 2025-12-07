import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
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

	public List<Integer> bfsTraversal() {
		List<Integer> list = new ArrayList<>();
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		bfsTraversal(list, queue);
		return list;
	}

	public void bfsTraversal(List<Integer> list, Queue<Node> queue) {
		// Queue<Integer> queue = new ArrayDeque<>();
		while (!queue.isEmpty()) {
			if (queue.peek() == null)	return;
			if (queue.peek().left != null)	queue.add(queue.peek().left);
			if (queue.peek().right != null)	queue.add(queue.peek().right);
			list.add(queue.remove().value);
		}
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

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the number of terms: ");
	    int n = sc.nextInt();
	    int[] array = new int[n];
	    System.out.println("Enter the array: ");
	    for (int index = 0; index < n; index++) {
	    	array[index] = sc.nextInt();
	    }
	    BFS tree = new BFS();
	    root = tree.buildTree(array);
	    tree.display();
	    List<Integer> result = tree.bfsTraversal();
	    System.out.println(result);
	    sc.close();
	}
}