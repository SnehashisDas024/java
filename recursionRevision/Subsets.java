import java.util.ArrayList;
import java.util.Scanner;

public class Subsets {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the string");
    String s = sc.nextLine();
    ArrayList<String> result = new ArrayList<>();
    Subsets obj = new Subsets();
    result = obj.subSeqArrayList("", s);
    System.out.println("Direct print method: ");
    obj.subseq("", s);
    System.out.println();
    System.out.println(result);
    ArrayList<String> resultIterative = new ArrayList<>();
    resultIterative = obj.iterativeSubsets(s);
    System.out.println(resultIterative);
    sc.close();
  }

  public void subseq(String p, String up) {
    if (up.length() == 0) {
      System.out.print(p + "\t");
      return;
    }
    char ch = up.charAt(0);
    subseq(p + ch, up.substring(1));
    subseq(p, up.substring(1));
  }

  public ArrayList<String> subSeqArrayList(String p, String up) {
    if (up.length() == 0) {
      ArrayList<String> list = new ArrayList<>();
      list.add(p);
      return list;
    }
    char ch = up.charAt(0);
    ArrayList<String> left = subSeqArrayList(p + ch, up.substring(1));
    ArrayList<String> right = subSeqArrayList(p, up.substring(1));
    left.addAll(right);
    return left;
  }

  public ArrayList<String> iterativeSubsets(String s) {
    ArrayList<String> subseq = new ArrayList<>();
    subseq.add("");
    for (char ch : s.toCharArray()) {
      int size = subseq.size();
      for (int i = 0; i < size; i++) {
        subseq.add(subseq.get(i) + ch);
      }
    }
    return subseq;
  }
}
