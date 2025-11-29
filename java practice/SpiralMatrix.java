import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int left = 0, top = 0, i;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        // while (top <= bottom && left <= right)
        // {   for (i = left; i <= right; i++){
        //         result.add(matrix[top][i]);
        //     }
        //     top++;
        //     for (i = top; i <= bottom; i++){
        //         result.add(matrix[i][right]);
        //     }
        //     right--;
        //     for (i = right; i >= left; i--){
        //         result.add(matrix[bottom][i]);
        //     }
        //     bottom--;
        //     for (i = bottom; i >= top; i--){
        //         result.add(matrix[i][left]);
        //     }
        //     left++;
        // }
        // return result;
        while (top <= bottom && left <= right) {

            // 1. Traverse Right (Top row)
            for (i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Move top boundary down

            // 2. Traverse Down (Rightmost column)
            // Check if there are still rows to traverse vertically
            if (top <= bottom) {
                for (i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                right--; // Move right boundary left
            }

            // 3. Traverse Left (Bottom row)
            // Check if there are still rows to traverse horizontally
            if (left <= right && top <= bottom) { // Both conditions needed for horizontal traversal
                for (i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Move bottom boundary up
            }

            // 4. Traverse Up (Leftmost column)
            // Check if there are still columns to traverse vertically
            if (left <= right && top <= bottom) { // Both conditions needed for vertical traversal
                for (i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Move left boundary right
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();

        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };

        List<Integer> result = sm.spiralOrder(matrix);
        System.out.println("Spiral Order: " + result);
    }
}
