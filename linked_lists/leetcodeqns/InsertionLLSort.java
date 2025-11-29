public class InsertionLLSort {
  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode nextNode) {
      this.val = val;
      this.next = nextNode;
    }
  }

  // public ListNode insertionSort(ListNode head) {
  // if (head == null || head.next == null)
  // return head;
  //
  // ListNode temp = head.next;
  // ListNode prev = head;
  // while (temp != null) {
  // if (temp.val < prev.val) {
  // ListNode hold = temp.next;
  // temp.next = prev;
  //
  // }
  // }
  // }
}
