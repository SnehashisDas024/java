public class Palindrome {

    public ListNode head;
    
    public boolean isPalindrome(ListNode head){
        if (head == null || head.next == null){
            return true;
        }
        boolean result = true;
        
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){ // Finds the middle of the Linked List (slow becomes the 2nd middle for even inputs. To have first middle, add a .next to each)
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.value != secondHalf.value)
                return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return result;
    }

    public static class ListNode{
        int value;
        ListNode next;

        public ListNode(){}

        public ListNode(int val, ListNode nextnode){
            this.value = val;
            this.next = nextnode;
        }

        public ListNode(int val){
            this.value = val;
        }
    }

    public ListNode reverse(ListNode start) {
        ListNode prev = null;
        ListNode curr = start;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

}