public class PairSum2130 {
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

  public int pairSum(ListNode head) {
    if (head == null)
      return 0;

    ListNode start = head;
    ListNode middle = middle(head);
    ListNode end = reverse(middle);

    // int steps = size(head) / 2;
    int maxSum = 0;

    while (start != null) {
      maxSum = Math.max(maxSum, start.val + end.val);
      start = start.next;
      end = end.next;
    }

    return maxSum;
  }

  public int size(ListNode head) {
    ListNode temp = head;
    int size = 0;
    while (temp != null) {
      size += 1;
      temp = temp.next;
    }
    return size;
  }

  public ListNode middle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
      ListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }

    return prev;
  }
}
