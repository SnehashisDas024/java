import java.util.Scanner;

public class BinaryTree {
    public class Node {
        int value;
        Node left;
        Node right;

        public Node(int val) {
            this.value = val;
        }
    }

    public Node root;

    public void createTree(Scanner scanner) {
        System.out.println("Enter the root value: ");
        int value = scanner.nextInt();
        root = new Node(value);
        createTree(scanner, root);
    }

    public void createTree(Scanner scanner, Node currentNode) {
        System.out.println("Do you want to insert a value to the left of " + currentNode.value + "?");
        boolean choice = scanner.nextBoolean();
        if (choice) {
            System.out.println("Enter the value:");
            int value = scanner.nextInt();
            currentNode.left = new Node(value);
            createTree(scanner, currentNode.left);
        }

        System.out.println("Do you want to insert a value to the right of " + currentNode.value + "?");
        choice = scanner.nextBoolean();
        if (choice) {
            System.out.println("Enter the value:");
            int value = scanner.nextInt();
            currentNode.right = new Node(value);
            createTree(scanner, currentNode.right);
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
            for (int i = 0; i < level - 1; i++) { // 0 theke start hochhe tai jekhane input hobe sekhane cursor ta niye jaoa hochhe
                System.out.print("|\t\t");
            }
            System.out.println("|-------->" + node.value);
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree ob = new BinaryTree();
        ob.createTree(sc);
        ob.display();
        System.out.println("PreOrder: ");
        ob.preorder();
        System.out.println("\nInOrder");
        ob.inorder();
        System.out.println("\nPostOrder");
        ob.postorder();
    }
}