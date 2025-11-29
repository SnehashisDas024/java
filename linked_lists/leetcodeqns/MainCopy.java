// public class MainCopy {
//   public static void main(String[] args) {
//     CopyRndmPtr list = new CopyRndmPtr();
//
//     CopyRndmPtr.Node head = list.new Node(2);
//
//   }
// }
public class MainCopy {

  public static void printList(CopyRndmPtr.Node head) {
    if (head == null) {
      System.out.println("List is empty.");
      return;
    }

    CopyRndmPtr.Node temp = head;
    while (temp != null) {
      // Print current node's value
      System.out.print("[Val: " + temp.val);

      // Print the value of the node pointed to by the random pointer
      if (temp.random != null) {
        System.out.print(", Random: " + temp.random.val + "]");
      } else {
        System.out.print(", Random: null]");
      }

      if (temp.next != null) {
        System.out.print(" -> ");
      }

      temp = temp.next;
    }
    System.out.println("\n-------------------------------------");
  }

  public static void main(String[] args) {
    // We need an instance of the outer class to create instances of the inner Node
    // class.
    CopyRndmPtr listHandler = new CopyRndmPtr();

    // --- Create a sample list ---
    // Structure: 7 -> 13 -> 11 -> 10 -> 1 -> null
    CopyRndmPtr.Node node1 = listHandler.new Node(7);
    CopyRndmPtr.Node node2 = listHandler.new Node(13);
    CopyRndmPtr.Node node3 = listHandler.new Node(11);
    CopyRndmPtr.Node node4 = listHandler.new Node(10);
    CopyRndmPtr.Node node5 = listHandler.new Node(1);

    // Connect the 'next' pointers
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;

    // Connect the 'random' pointers
    // node1.random is null
    node2.random = node1; // 13's random points to 7
    node3.random = node5; // 11's random points to 1
    node4.random = node3; // 10's random points to 11
    node5.random = node1; // 1's random points to 7

    System.out.println("Original List:");
    printList(node1);

    // --- Call the copy method ---
    CopyRndmPtr.Node copiedHead = listHandler.copyRandomList(node1);

    System.out.println("Copied List (using the incomplete method):");
    System.out.println("Notice how all 'Random' pointers are null because they weren't copied.");
    printList(copiedHead);

    // --- Test edge case: empty list ---
    System.out.println("Testing with an empty list:");
    CopyRndmPtr.Node emptyHead = listHandler.copyRandomList(null);
    printList(emptyHead);
  }
}
