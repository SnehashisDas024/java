import java.util.Scanner;

public class AVLMain {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    AVL obj = new AVL();
    obj.insertinBST(sc);
    obj.display();
    sc.close();
  }
}
// 50,30,70,20,40,60,80,10,25,5,45,47,65,75,85,62,63,90,95,1,2