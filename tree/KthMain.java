public class KthMain {
  public static void main(String[] args) {

    // Test case 1 (LeetCode example)
    System.out.println("Test case 1:");
    KthLargest kthLargest1 = new KthLargest(3, new int[] { 4, 5, 8, 2 });
    System.out.println(kthLargest1.add(3)); // expected 4
    System.out.println(kthLargest1.add(5)); // expected 5
    System.out.println(kthLargest1.add(10)); // expected 5
    System.out.println(kthLargest1.add(9)); // expected 8
    System.out.println(kthLargest1.add(4)); // expected 8

    System.out.println();

    // Test case 2
    System.out.println("Test case 2:");
    KthLargest kthLargest2 = new KthLargest(1, new int[] {});
    System.out.println(kthLargest2.add(-3)); // expected -3
    System.out.println(kthLargest2.add(-2)); // expected -2
    System.out.println(kthLargest2.add(-4)); // expected -2
    System.out.println(kthLargest2.add(0)); // expected 0
    System.out.println(kthLargest2.add(4)); // expected 4

    System.out.println();

    // Test case 3
    System.out.println("Test case 3:");
    KthLargest kthLargest3 = new KthLargest(2, new int[] { 0 });
    System.out.println(kthLargest3.add(-1)); // expected -1
    System.out.println(kthLargest3.add(1)); // expected 0
    System.out.println(kthLargest3.add(-2)); // expected 0
    System.out.println(kthLargest3.add(-4)); // expected 0
    System.out.println(kthLargest3.add(3)); // expected 1
  }
}
