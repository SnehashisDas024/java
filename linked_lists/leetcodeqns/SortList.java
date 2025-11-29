// import java.util.Scanner;

public class SortList {

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

  public ListNode sortList(ListNode head) {
    return mergeSort(head);
  }

  public ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null)
      return head;

    // split: get node before the middle node to split clearly
    // We use the node before the middle one so that the call can be done easily
    ListNode midPrev = midPrevFinder(head);
    ListNode right = midPrev.next;
    midPrev.next = null;

    ListNode leftSorted = mergeSort(head);
    ListNode rightSorted = mergeSort(right);
    return merge2SortedLists(leftSorted, rightSorted);
  }

  // Returns the node BEFORE the middle. For even length, left has n/2 nodes
  private ListNode midPrevFinder(ListNode head) {
    ListNode slow = head, fast = head.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  public ListNode merge2SortedLists(ListNode list1, ListNode list2) {
    // ListNode result = new ListNode(0, null);
    // ListNode dummy = result;
    //
    // while(list1 != null && list2 != null) {
    // if(list1.val <= list2.val) {
    // result.next = list1;
    // result = result.next;
    // list1 = list1.next;
    // }
    // else {
    // result.next = list2;
    // result = result.next;
    // list2 = list2.next;
    // }
    // }
    // while (list1 != null) {
    // result.next = list1;
    // result = result.next;
    // list1 = list1.next;
    // }
    // while (list2 != null) {
    // result.next = list2;
    // result = result.next;
    // list2 = list2.next;
    // }
    // result.next = null;
    // return dummy.next;
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;

    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        tail.next = list1;
        list1 = list1.next;
      } else {
        tail.next = list2;
        list2 = list2.next;
      }
      tail = tail.next;
    }
    tail.next = (list1 != null) ? list1 : list2;
    return dummy.next;
  }
}
