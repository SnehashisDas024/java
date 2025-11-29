import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuplicateSubsets {
    // public ArrayList<ArrayList<Integer>> subsets(int[] arr){
    //     Arrays.sort(arr);
    //     ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    //     result.add(new ArrayList<>());
    //     int j;
    //     for (int i = 0; i < arr.length; i++) {
    //         int n = result.size();
    //         if (i >= 1 && arr[i] == arr[i - 1]){
    //             j = n / 2; //Checkpoint
    //         }
    //         else{
    //             j = 0;
    //         }
    //         for (int k = j; k < n; k++) {
    //             ArrayList<Integer> list = new ArrayList<>(result.get(k));
    //             list.add(arr[i]);
    //             result.add(list);
    //         }
    //     }
    //     return result;
    // }

    public List<List<Integer>> subsetsWithDup(int[] arr) {
    Arrays.sort(arr);
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());

    int start = 0, end = 0;

    for (int i = 0; i < arr.length; i++) {
        start = 0;
        if (i > 0 && arr[i] == arr[i - 1]) {
            start = end + 1;
        }
        end = result.size() - 1;

        int n = result.size();
        for (int j = start; j < n; j++) {
            List<Integer> subset = new ArrayList<>(result.get(j));
            subset.add(arr[i]);
            result.add(subset);
        }
    }

    return result;
}

    public static void main(String[] args) {
        DuplicateSubsets ob = new DuplicateSubsets();
        int[] arr = {2, 2, 2};
        System.out.println(ob.subsetsWithDup(arr));
    }
}
