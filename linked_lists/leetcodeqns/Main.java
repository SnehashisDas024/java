public class Main {
    public static void main(String[] args) {
        // Build a sample palindrome list: 1 -> 2 -> 3 -> 2 -> 1
        Palindrome.ListNode n5 = new Palindrome.ListNode(1);
        Palindrome.ListNode n4 = new Palindrome.ListNode(2, n5);
        Palindrome.ListNode n3 = new Palindrome.ListNode(3, n4);
        Palindrome.ListNode n2 = new Palindrome.ListNode(2, n3);
        Palindrome.ListNode n1 = new Palindrome.ListNode(1, n2);

        Palindrome palindromeChecker = new Palindrome();

        boolean result = palindromeChecker.isPalindrome(n1);

        System.out.println("Is the linked list a palindrome? " + result);
    }
}
