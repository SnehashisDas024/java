public class MainAltConnect {
  public static void printList(ListAltConnect.ListNode head) {
    if (head == null) {
      System.out.println("List is empty.");
      return;
    }
    ListAltConnect.ListNode temp = head;
    while (temp != null) {
      System.out.print(temp.val + " -> ");
      temp = temp.next;
    }
    System.out.println("END");
  }

  public static void main(String[] args) {
    ListAltConnect list = new ListAltConnect();

    ListAltConnect.ListNode head1 = list.new ListNode(24,
        list.new ListNode(57,
            list.new ListNode(78,
                list.new ListNode(12, null))));

    printList(head1);

    ListAltConnect.ListNode head2 = list.new ListNode(74,
        list.new ListNode(127,
            list.new ListNode(68,
                list.new ListNode(342, null))));

    printList(head2);

    System.out.println("The Alternatingly connected list is: ");

    ListAltConnect.ListNode head = list.connectAlt(head1, head2);

    printList(head);

  }
}
