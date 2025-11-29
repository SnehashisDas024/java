public class SortMain {

  public static void printList(SortList.ListNode head) {
    if (head == null) {
      System.out.println("null");
      return;
    }
    SortList.ListNode current = head;
    while (current != null) {
      System.out.print(current.val + " -> ");
      current = current.next;
    }
    System.out.println("null");
  }

  public static void main(String[] args) {
    SortList list = new SortList();

    SortList.ListNode head1 = list.new ListNode(4,
        list.new ListNode(3,
            list.new ListNode(5,
                list.new ListNode(9))));

    printList(head1);

    head1 = list.mergeSort(head1);

    printList(head1);

  }
}
