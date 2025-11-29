// Find the minimum number of brackets to be removed to make the given sequence
// balanced

import java.util.Scanner;
import java.util.Stack;

public class MinBrackets {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the brackets string");
    String str = sc.next();
    int ans = bracketsLeft(str);
    System.out.println("The number of brackets to be removed is: " + ans);
    sc.close();
  }

  public static int bracketsLeft(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      Character ch = s.charAt(i);
      if (stack.isEmpty() || ch == '(' || ch == '{' || ch == '[')
        stack.push(ch);
      else {
        Character p = stack.peek();
        if ((ch == ')' && p == '(') ||
            (ch == '}' && p == '{') ||
            (ch == ']' && p == '['))
          stack.pop();
        else
          return stack.push(ch);
      }
    }
    return stack.size();
  }
}
