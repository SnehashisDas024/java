import java.util.Scanner;
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the character");
        char ch = sc.next().charAt(0);
        if (ch>=65 && ch<=90) {
            System.out.println("The character is uppercase");
        } else if (Character.isLowerCase(ch)) {
            System.out.println("The character is lowercase");
        } else {
            System.out.println("The character is neither uppercase nor lowercase");
        }
        sc.close();
        
}
}
