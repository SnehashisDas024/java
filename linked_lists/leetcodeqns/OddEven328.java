public class OddEven328 {
  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode separateOddEven(ListNode head) {
    if (head == null || head.next == null || head.next.next == null)
      return head;
    ListNode odd = head;
    ListNode even = head.next;
    ListNode evenHead = even;

    while (odd != null && even != null && even.next != null) {
      odd.next = even.next;
      even.next = even.next.next;
      even = even.next;
      odd = odd.next;
      odd.next = evenHead;
    }

    return head;
  }

}
