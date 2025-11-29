import java.util.Scanner;

public class NoA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the string: ");
    String s = sc.nextLine();
    System.out.println("The string without the letter 'a' is: " + removeA(s));
    sc.close();
  }

  public static String removeA(String s) {
    if (s.length() == 0)
      return "";
    if (s.charAt(0) == 'a')
      return removeA(s.substring(1));
    else
      return s.charAt(0) + removeA(s.substring(1));
  }
}
