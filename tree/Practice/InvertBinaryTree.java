import java.util.Scanner;

public class InvertBinaryTree {
	static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static Node root = null;

    // Build a tree from an array containing nulls
    public static Node buildTree(Integer[] arr) {
        return buildTreeHelper(arr, 0);
    }

    private static Node buildTreeHelper(Integer[] arr, int index) {
        // Out of bounds or null entry → no node
        if (index >= arr.length || arr[index] == null) {
            return null;
        }

        Node root = new Node(arr[index]);

        // Recursively create children
        root.left = buildTreeHelper(arr, 2 * index + 1);
        root.right = buildTreeHelper(arr, 2 * index + 2);

        return root;
    }

    public static void display() {
        display(root, 0);
    }

    public static void display(Node node, int level) {
        if (node == null) {
            return;
        }

        display(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) { // 0 theke start hochhe tai jekhane input hobe sekhane cursor ta niye jaoa hochhe
                System.out.print("|\t\t");
            }
            System.out.println("|-------->" + node.val);
        } else {
            System.out.println(node.val);
        }
        display(node.left, level + 1);
    }

    public void invertTree(Node node) {
    	if (node == null)	return;
    	Node temp = node.left;
    	node.left = node.right;
    	node.right = temp;
    	// node.left = invertTree(node.left);
    	// node.right = invertTree(node.right);
    	invertTree(node.left);
    	invertTree(node.right);
    	// return node;
    }

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the number of terms in the tree: ");
	    int n = sc.nextInt();

	    Integer[] arr = new Integer[n];
	    System.out.println("Enter the elements in the array: ");

	    for (int i = 0; i < n; i++) {
	    	String value = sc.next();
			if (value.equalsIgnoreCase("null")) {
			    arr[i] = null;
			} else {
			    arr[i] = Integer.parseInt(value);
			}
	    }
	    root = buildTree(arr);
	    display();
	    InvertBinaryTree ob = new InvertBinaryTree();
	    System.out.println("Inverted: ");
	    ob.invertTree(root);
	    display();
	    sc.close();
	}
}
