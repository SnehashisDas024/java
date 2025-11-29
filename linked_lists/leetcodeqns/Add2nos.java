public class Add2nos {
    public ListNode head;

    public ListNode add(ListNode head1, ListNode head2){
        // if (head1 == null && head2 == null)
        //     return head1;
        // else if(head1 == null && head2 != null)
        //     return head2;
        // else if(head1 != null && head2 == null)
        //     return head1;
        if (head1 == null)  return head2;
        if (head2 == null)  return head1;

        ListNode result = null;
        ListNode rev1 = reverse(head1);
        ListNode rev2 = reverse(head2);
        int carry = 0, sum = 0;
        
        while (rev1 != null && rev2 != null) {
            ListNode calc = new ListNode();
            sum = rev1.value + rev2.value + carry;
            calc.value = sum % 10;
            carry = sum / 10;
            calc.next = result;
            result = calc;
            rev1 = rev1.next;
            rev2 = rev2.next;
        }
        
        if (rev1 != null) {
            while (rev1 != null) {
                ListNode calc = new ListNode();
                sum = rev1.value + carry;
                calc.value = sum % 10;
                carry = sum / 10;
                calc.next = result;
                result = calc;
                rev1 = rev1.next;
            }
            // if (carry > 0) {
            //     ListNode carryvalue = new ListNode(carry);
            //     carryvalue.next = result;
            //     result = carryvalue;
            // }
        }

        if (rev2 != null) {
            while (rev2 != null) {
                ListNode calc = new ListNode();
                sum = rev2.value + carry;
                calc.value = sum % 10;
                carry = sum / 10;
                calc.next = result;
                result = calc;
                rev2 = rev2.next;
            }
            // if (carry > 0) {
            //     ListNode carryvalue = new ListNode(carry);
            //     carryvalue.next = result;
            //     result = carryvalue;
            // }
        }

        if (carry > 0) {
            ListNode carryvalue = new ListNode(carry);
            carryvalue.next = result;
            result = carryvalue;
        }

        return result;
    }
    public static class ListNode {
        int value;
        ListNode next;

        ListNode() {}
        ListNode(int val){
            this.value = val;
        }
        ListNode(int val, ListNode nextnode){
            this.value = val;
            this.next = nextnode;
        }
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev; 
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
