// Query function -> the action that is working in the given array that makes up the original tree.
// this function may be sum, product, max in a range, min in a range and so on

// When we should use Segment Tree -> When we have to perform a query in a range in O(log n) time

import java.util.Scanner;
public class SegmentTree {

	public class Node { // Node of a segement tree. The final value of the node is the final value determined by the query function in that interval
		int value;
		int startInterval;
		int endInterval;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		}

		public Node(int start, int end) {
			this.startInterval = start;
			this.endInterval = end;
			// this.left = null;
			// this.right = null;
		}

		public Node(int value, int start, int end) {
			this.value = value;
			this.startInterval = start;
			this.endInterval = end;
			this.left = null;
			this.right = null;
		}
	}

	public static Node root = null;

	public Node buildTree(int[] arr) {
		root = buildTree(arr, 0, arr.length - 1);
		return root;
	}

	public Node buildTree(int[] arr, int start, int end) {
		if (start == end) {
			Node node = new Node(arr[start], start, end);
			return node;
		}
		Node node = new Node(start, end);
		int mid = (start + end) / 2;

		node.left = buildTree(arr, start, mid);
		node.right = buildTree(arr, mid + 1, end);

		node.value = node.left.value + node.right.value;
		return node;
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
            System.out.println("|-------->" + node.value);
        } else {
            System.out.println(node.value);
        }
        display(node.left, level + 1);
    }

    // Query - what query sunction has done in a range
    public int query(int start, int end) {
    	return query(root, start, end);
    }

    public int query(Node node, int start, int end) {
    	if (node.startInterval >= start && node.endInterval <= end) {
    		// node interval is completely inside query interval
    		return node.value;
    	} else if (node.startInterval > end || node.endInterval < start) {
    		// node interval is completely outside query interval
    		return 0; // Default value
    	} else {
    		return query(node.left, start, end) + query(node.right, start, end);
    	}
    }

    public void update(int index, int value) {
    	root.value = update(root, index, value);
    }

    public int update(Node node, int index, int value) {
    	if (index >= node.startInterval && index <= node.endInterval) {
    		if (index == node.startInterval && index == node.endInterval) {
    			node.value = value;
    			return node.value;
    		} else {
    			int leftAns = update(node.left, index, value);
    			int rightAns = update(node.right, index, value);
    			node.value = leftAns + rightAns;
    			return node.value;
    		}
    	}
    	return node.value;
    }

    public static void main(String[] args) {
        SegmentTree tree = new SegmentTree();
        Scanner sc = new Scanner(System.in);
        int[] arr = {3, 8, 7, 6, -2, -8, 4, 9};
        tree.buildTree(arr);
        display();
        System.out.println("Enter the interval whose sum you want: ");
        int start = sc.nextInt();
        int end = sc.nextInt();
        int queryResult = tree.query(start, end);
        System.out.println("The sum of the given range is: " + queryResult);
        System.out.println("Enter the index whose value you want to change and the new value: ");
        int idx = sc.nextInt();
        int val = sc.nextInt();
        tree.update(idx, val);
        display();
        sc.close();
    }
}