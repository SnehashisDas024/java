import java.util.ArrayList;

public class IterativeSubsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] s) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());
        
        for (int num : s){
            int n = result.size();
            for(int i = 0; i < n; i++){
                ArrayList<Integer> list = new ArrayList<>(result.get(i));
                list.add(num);
                result.add(list);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        IterativeSubsets ob = new IterativeSubsets();
        int[] arr = {1, 2, 3};
        System.out.println(ob.subsets(arr));
    }
}
