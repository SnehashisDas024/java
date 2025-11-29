import java.util.Scanner;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree obj = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        obj.insertinBST(sc);
        obj.display();
        System.out.println("PreOrder: ");
        obj.preorder();
        System.out.println("\nPostOrder");
        obj.postorder();
        System.out.println("\nInOrder");
        obj.inorder();
    }
}