public class Main2 {
    public static void main(String[] args) {
        // create two numbers as linked lists
        // number 1 = 617 (6 -> 1 -> 7)
        Add2nos.ListNode l1 = new Add2nos.ListNode(2);
        l1.next = new Add2nos.ListNode(4);
        l1.next.next = new Add2nos.ListNode(3);

        // number 2 = 295 (2 -> 9 -> 5)
        Add2nos.ListNode l2 = new Add2nos.ListNode(5);
        l2.next = new Add2nos.ListNode(6);
        l2.next.next = new Add2nos.ListNode(4);

        // add them
        Add2nos adder = new Add2nos();
        Add2nos.ListNode result = adder.add(l1, l2);

        // print result
        printList(result); // should print 912 (9 -> 1 -> 2)
    }

    public static void printList(Add2nos.ListNode node) {
        while (node != null) {
            System.out.print(node.value);
            if (node.next != null)
                System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }
}
