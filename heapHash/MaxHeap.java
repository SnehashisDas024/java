import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MaxHeap {
  public ArrayList<Integer> formMaxHeap(ArrayList<Integer> arr) {
    ArrayList<Integer> maxHeap = new ArrayList<>();
    int n = arr.size();
    for (int i = 1; i <= n; i++) {
      int val = arr.get(i - 1);
      maxHeap.add(val);
      if (i == 1)
        continue;
      int j = i;
      while (j > 1 && (maxHeap.get(j - 1) > maxHeap.get((j / 2) - 1))) {
        Collections.swap(maxHeap, (j - 1), ((j / 2) - 1));
        j = j / 2;
      }
    }
    return maxHeap;
  }

  public ArrayList<Integer> removeElement(ArrayList<Integer> maxHeap, int index) {
    int n = maxHeap.size();

    // Invalid index
    if (index < 1 || index > n)
      return maxHeap;

    // If removing last Element
    if (index == n) {
      maxHeap.remove(index - 1);
      return maxHeap;
    }

    // Swap with last and remove
    Collections.swap(maxHeap, index - 1, n - 1);
    maxHeap.remove(n - 1);
    n--;

    int i = index;

    // Heapify down -> If parent is larger than previously last element
    while (true) {
      int left = 2 * i;
      int right = 2 * i + 1;
      int largest = i;

      if (left <= n && maxHeap.get(left - 1) > maxHeap.get(largest - 1))
        largest = left;
      if (right <= n && maxHeap.get(right - 1) > maxHeap.get(largest - 1))
        largest = right;
      if (largest != i) {
        Collections.swap(maxHeap, i - 1, largest - 1);
        i = largest;
      } else {
        break;
      }
    }

    // Heapify up -> If parent is smaller than the previously last element
    while (i > 1 && maxHeap.get(i - 1) > maxHeap.get((i / 2) - 1)) {
      Collections.swap(maxHeap, i - 1, (i / 2) - 1);
      i = i / 2;
    }

    return maxHeap;
  }

  public ArrayList<Integer> heapSort(ArrayList<Integer> maxHeap) {
    ArrayList<Integer> sortedArray = new ArrayList<>();

    while (!maxHeap.isEmpty()) {
      // Root is always the maximum
      int max = maxHeap.get(0);
      sortedArray.add(max);

      // Remove the root and heapify the rest properly
      removeElement(maxHeap, 1);
    }

    return sortedArray;
  }

  public ArrayList<Integer> heapFromArray(ArrayList<Integer> array) {
    int n = array.size();

    for (int index = n / 2; index >= 1; index--) {
      int largest;
      int i = index;
      while (true) {
        int left = 2 * i;
        int right = 2 * i + 1;
        largest = i;
        if (left <= n && array.get(largest - 1) < array.get(left - 1))
          largest = left;
        if (right <= n && array.get(largest - 1) < array.get(right - 1))
          largest = right;
        if (largest != i) {
          Collections.swap(array, i - 1, largest - 1);
          i = largest;
        } else {
          break;
        }
      }
    }

    return array;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements: ");
    int n = sc.nextInt();
    System.out.println("Enter the elements in the array: ");
    ArrayList<Integer> arr = new ArrayList<>();
    int val;
    for (int i = 0; i < n; i++) {
      val = sc.nextInt();
      arr.add(val);
    }
    System.out.println("Original array: ");
    System.out.println(arr);
    MaxHeap ob = new MaxHeap();
    ArrayList<Integer> result = ob.formMaxHeap(arr);
    System.out.println("Max Heap: ");
    System.out.println(result);
    System.out.println("In-place heap-formation: " + ob.heapFromArray(arr));
    // System.out.println("Enter the index of the element you want to remove: ");
    // int idx = sc.nextInt();
    // System.out.println("The max heap after removal: ");
    // System.out.println(ob.removeElement(result, idx));
    System.out.println("The sorted array: " + ob.heapSort(result));
    sc.close();
  }
}
