import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the String(Only the various types of brackets)");
    String str = sc.next();

    ValidParentheses checkValid = new ValidParentheses();
    if (checkValid.isValid(str)) {
      System.out.println("The brackets are properly matched");
    } else {
      System.out.println("The brackets are not properly matched");
    }

    sc.close();
  }

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    stack.add(s.charAt(0));

    for (int i = 1; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(' || ch == '{' || ch == '[') {
        stack.push(ch);
      } else {
        if (stack.isEmpty())
          return false;
        char top = stack.pop();
        if ((ch == ')' && top != '(') ||
            (ch == '}' && top != '{') ||
            (ch == ']' && top != '[')) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
