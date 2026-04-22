
import java.util.PriorityQueue;

class KthLargest {
  PriorityQueue<Integer> pq = new PriorityQueue<>();
  int el;

  public KthLargest(int k, int[] nums) {
    // Initialize your data structure here
    for (int i : nums) {
      pq.add(i);
    }
    while (pq.size() > k) {
      pq.remove();
    }
    el = k;
  }

  public int add(int val) {
    // Add val to the stream and return the kth largest element
    pq.add(val);
    while (pq.size() > el) {
      pq.remove();
    }
    int kthLargestVal = pq.peek();
    return kthLargestVal;
  }
}
