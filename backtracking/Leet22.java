
import java.util.*;

class Leet22 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of pairs: ");
    int n = sc.nextInt();
    Leet22 ob = new Leet22();
    ArrayList<String> result = ob.generateParentheses(n, 0, 0, "");
    System.out.println("All combinations of parentheses with " + n + " pairs of parentheses are:\n" + result);
    sc.close();
  }

  public ArrayList<String> generateParentheses(int n, int cl, int cr, String p) {
    ArrayList<String> result = new ArrayList<>();
    if (cl == n && cr == n) {
      result.add(p);
      return result;
    }
    // if (cl < n && cr <= cl) {
    // ArrayList<String> left = generateParentheses(n, cl + 1, cr, p + "(");
    // ArrayList<String> right = generateParentheses(n, cl, cr + 1, p + ")");
    // left.addAll(right);
    // return left;
    // } else if (cl == 0) {
    // ArrayList<String> left = generateParentheses(n, cl + 1, cr, p + "(");
    // return left;
    // } else { // if (cl == n && cr < n)
    // ArrayList<String> right = generateParentheses(n, cl, cr + 1, p + ")");
    // return right;
    // }
    if (cl < n) {
      ArrayList<String> left = generateParentheses(n, cl + 1, cr, p + "(");
      result.addAll(left);
    }
    if (cr < cl) {
      ArrayList<String> right = generateParentheses(n, cl, cr + 1, p + ")");
      result.addAll(right);
    }
    return result;
  }
}
