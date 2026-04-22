import java.util.HashSet;
import java.util.Scanner;

class PortalTeleportation {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of rooms: ");
    int n = sc.nextInt();
    System.out.println("Enter the portals in rooms: ");
    int[] arr = new int[n];
    for (int index = 0; index < n; index++) {
      arr[index] = sc.nextInt();
    }
    HashSet<Integer> hashSet = new HashSet<>();

  }
}
