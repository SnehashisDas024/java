import java.util.Scanner;

public class HappyNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number: ");
    int n = sc.nextInt();
    HappyNumber ob = new HappyNumber();
    System.out.println("Is " + n + " a happy number?" + ob.happyNumberCheck(n));
    sc.close();
  }

  public boolean happyNumberCheck(int num) {
    if (num == 1)
      return true;
    int slow = num, fast = digitSquareSum(num);
    while (slow != fast) {
      if (slow == 1 || fast == 1) {
        return true;
      }
      slow = digitSquareSum(slow);
      fast = digitSquareSum(digitSquareSum(fast));
      // fast = digitSquareSum(fast);
    }
    // return false;
    return slow == 1;
  }

  public int digitSquareSum(int num) {
    int d, squareSum = 0;

    while (num != 0) {
      d = num % 10;
      squareSum = squareSum + (d * d);
      num /= 10;
    }

    return squareSum;
  }
}
