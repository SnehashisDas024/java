import java.util.ArrayList;
import java.util.Scanner;

public class Permutations {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the string: ");
    String s = sc.nextLine();
    Permutations obj = new Permutations();
    System.out.println("The permutations are: ");
    obj.permutation("", s);
    ArrayList<String> result = new ArrayList<>();
    result = obj.permutationAll("", s);
    System.out.println(result);
    sc.close();
  }

  public ArrayList<String> permutationAll(String p, String up) {
    if (up.isEmpty()) {
      ArrayList<String> list = new ArrayList<>();
      list.add(p);
      return list;
    }
    char ch = up.charAt(0);
    int size = p.length();
    ArrayList<String> result = new ArrayList<>();
    for (int i = 0; i <= size; i++) {
      String front = p.substring(0, i);
      String rear = p.substring(i, size);
      ArrayList<String> listReturn = permutationAll(front + ch + rear, up.substring(1));
      result.addAll(listReturn);
    }
    return result;
  }

  public void permutation(String p, String up) {
    if (up.length() == 0) {
      System.out.println(p);
      return;
    }
    char ch = up.charAt(0);
    int size = p.length();
    for (int i = 0; i <= size; i++) {
      String front = p.substring(0, i);
      String rear = p.substring(i, size);
      permutation(front + ch + rear, up.substring(1));
    }
  }
}
