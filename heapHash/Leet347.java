
import java.util.*;

class Leet347 {
  public static void main(String[] args) {
    Leet347 sol = new Leet347();
    int[] nums = { 2, 1, 1, 2, 2, 3 };
    int k = 3;
    int[] result = sol.topKFrequent(nums, k);
    System.out.println(Arrays.toString(result));
  }

  public int[] topKFrequent(int[] nums, int k) {
    int val;
    Map<Integer, Integer> mapCount = new HashMap<>();
    for (int num : nums) {
      if (mapCount.containsKey(num)) {
        val = mapCount.get(num);
        mapCount.replace(num, val + 1);
      } else {
        mapCount.put(num, 1);
      }
    }

    // ArrayList<Integer> al = new ArrayList<>();
    // for (Map.Entry<Integer, Integer> entry : mapCount.entrySet()) {
    // al.add(entry.getValue());
    // }
    // Collections.sort(al);

    PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
    maxHeap.addAll(mapCount.entrySet());

    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = maxHeap.poll().getKey();
    }

    return result;
  }
}
