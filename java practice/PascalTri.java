import java.util.ArrayList;
import java.util.List;

public class PascalTri {
    public static void main(String[] args) {
        PascalTri sol = new PascalTri();
        int numRows = 5;
        List<List<Integer>> triangle = sol.generate(numRows);

        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++){
                if (j == 0 || j == i){
                    row.add(1);
                }
                else{
                    int value = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    row.add(value);
                }
            }
            result.add(row);
        }
        return result;
    }
}


























// public List<List<Integer>> generate(int numRows) {
//         List<List<Integer>> triangle = new ArrayList<>();

//         for (int i = 0; i < numRows; i++) {
//             List<Integer> row = new ArrayList<>();
//             for (int j = 0; j <= i; j++) {
//                 // First and last elements in the row are always 1
//                 if (j == 0 || j == i) {
//                     row.add(1);
//                 } else {
//                     // Element is sum of the two elements above it
//                     int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
//                     row.add(val);
//                 }
//             }
//             triangle.add(row);
//         }

//         return triangle;

//     }