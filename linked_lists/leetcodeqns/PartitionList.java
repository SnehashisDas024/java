public class PartitionList {
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

  public ListNode partition(ListNode head, int x) {
    // int idx = 0;
    if (head == null || head.next == null) {
      return head;
    }
    ListNode left = new ListNode(0, null);
    ListNode right = new ListNode(0, null);
    ListNode leftini = left;
    ListNode rightini = right;
    ListNode temp = head;
    ListNode prev = null;
    while (temp != null) {
      if (temp.val < x) {
        prev = temp.next;
        left.next = temp;
        left = left.next;
        temp.next = null;
        temp = prev;
      } else {
        prev = temp.next;
        right.next = temp;
        right = right.next;
        temp.next = null;
        temp = prev;
      }
    }
    left.next = rightini.next;
    return leftini.next;
  }
}
