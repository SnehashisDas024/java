import java.util.Scanner;

class Q7 {
//     public boolean isPalindrome(int x) {
//         String s = Integer.toString(x);
//         StringBuilder sb = new StringBuilder(s);
//         String reversed = sb.reverse().toString();
//         if (s.equals(reversed))
//             return true;
//         else
//             return false;
//   }
    public boolean isPalindrome(int x) {
        // Negative numbers and numbers ending in 0 (except 0 itself) aren't palindromes
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int reversed = 0;
        // Reverse half of the number
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        // For odd-length numbers, discard the middle digit with reversed / 10
        return x == reversed || x == reversed / 10;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q7 ob = new Q7();
        System.out.println("Enter a number");
        int n = sc.nextInt();
        if (ob.isPalindrome(n))
            System.out.println("Palindrome number");
        else
            System.out.println("Not Palindrome number");
        sc.close();
    }
}