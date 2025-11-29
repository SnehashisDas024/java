public class ListAltConnect {
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

  // Extremely messy, destroys old lists

  // public ListNode connectAlt(ListNode list1, ListNode list2) {
  // ListNode dummy = new ListNode(0);
  // ListNode dummy2 = dummy;
  // // ListNode temp1, temp2;
  // while (list1 != null && list2 != null) {
  // ListNode temp1 = list1.next;
  // ListNode temp2 = list2.next;
  // temp1.next = list2;
  // dummy.next = list1;
  // dummy = list2;
  // list1 = temp1;
  // list2 = temp2;
  // }
  // while (list1 != null) {
  // dummy.next = list1;
  // list1 = list1.next;
  // }
  // while (list2 != null) {
  // dummy.next = list2;
  // list2 = list2.next;
  // }
  // return dummy2.next;
  // }

  // Works properly, uses in-place weave <- the most efficient approach

  public ListNode connectAlt(ListNode list1, ListNode list2) {
    if (list1 == null)
      return list2;
    if (list2 == null)
      return list1;

    ListNode curr1 = list1;
    ListNode curr2 = list2;

    while (curr1 != null && curr2 != null) {
      // Save the next nodes BEFORE you change any pointers
      ListNode next1 = curr1.next;
      ListNode next2 = curr2.next;

      // Perform the weave
      curr1.next = curr2;
      curr2.next = next1;

      // Advance to the next pair
      curr1 = next1;
      curr2 = next2;
    }
    return list1;
  }

  // Works properly, uses dummy Node approach

  // blic ListNode connectAlt(ListNode list1, ListNode list2) {
  // ListNode dummyHead = new ListNode(0);
  //   ListNode tail = dummyHead;
  // 
  // ile (list1 != null && list2 != null) {
  // // Append from list1
  // tail.next = list1;
  // tail = tail.next;
  //     list1 = list1.next;
  // 
  // // Append from list2
  // tail.next = list2;
  // tail = tail.next;
  //   list2 = list2.next;
  //   }
  // 
  // // Append any leftovers
  //  (list1 != null) {
  //   tail.next = list1;
  // else if (list2 != null) {
  //   tail.next = list2;
  //   }
  // 
  // // Unlink the new list from the old lists to prevent cycles
  //   tail.next = null;
  // 
  //   return dummyHead.next;
  // }
}
