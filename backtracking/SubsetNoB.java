
import java.util.*;

class SubsetNoB {
  public static void main(String[] args) {
    System.out.println("All possible arrangements of A, B, C such that B is not present in the middle: ");
    SubsetNoB ob = new SubsetNoB();
    ob.subsetP("", "ABC");
  }

  public void subsetP(String p, String up) {
    if (p.length() == 2 && p.endsWith("B")) {
      return;
    } else if (p.length() == 3) {
      System.out.println(p);
      return;
    } else {
      for (int i = 0; i < up.length(); i++) {
        char ch = up.charAt(i);
        String remaining = up.substring(0, i) + up.substring(i + 1);
        subsetP(p + ch, remaining);
      }
    }
  }
}
