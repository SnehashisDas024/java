public class CopyRndmPtr {
  class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  public Node deepCopy(Node head) {
    Node temp = head;
    Node dummy = new Node(0);
    Node result = dummy;

    while (temp != null) {
      Node newNode = new Node(temp.val);
      newNode.next = null;
      dummy.next = newNode;
      dummy = dummy.next;
      temp = temp.next;
    }

    return result.next;
  }

  public Node alternatingConnect(Node list1, Node list2) {
    Node curr1 = list1;
    Node curr2 = list2;

    while (curr1 != null && curr2 != null) {
      Node next1 = curr1.next;
      Node next2 = curr2.next;

      curr1.next = curr2;
      curr2.next = next1;

      curr1 = next1;
      curr2 = next2;
    }

    return list1;
  }

  public void establishRandom(Node head) {
    Node temp1 = head;
    Node temp2 = head.next;

    while (temp1 != null) {
      if (temp1.random != null) {
        temp2.random = temp1.random.next;
      }
      temp1 = temp1.next.next;
      if (temp1 != null)
        temp2 = temp1.next;
    }
  }

  public Node separateLists(Node head) {
    Node temp1 = head;
    Node temp2 = head.next;

    Node result = temp2;

    while (temp1 != null || temp2 != null) {
      temp1.next = temp2.next;
      temp1 = temp1.next;
      if (temp1 == null)
        break;
      temp2.next = temp1.next;
      temp2 = temp2.next;
    }

    return result;
  }

  public Node copyRandomList(Node head) {
    // Step 1: Deep copy of the skeleton of the List
    // That is, using only next
    if (head == null) { // Edge case for head = []
    return null;
    }
    //
    // Node temp = head;
    //
    // Node dummy = new Node(0);
    // Node result = dummy;
    // // int c = 1;
    //
    // while (temp != null) {
    // Node newNode = new Node(temp.val);
    // newNode.next = null;
    // dummy.next = newNode;
    // dummy = newNode;
    // temp = temp.next;
    // }
    //
    // return result.next;

    // Step-1: Deep copy without random connections

    Node head2 = deepCopy(head);

    // Step-2: join the 2 lists alternatively

    Node head3 = alternatingConnect(head, head2);

    // Step-3: Establish the random pointers

    establishRandom(head3);

    // Step-4: Separate the lists and receive the deep copy

    Node result = separateLists(head3);

    return result;
  }
}
