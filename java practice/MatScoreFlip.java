public class MatScoreFlip {
    public int matrixScore(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length; 
        for (int i = 0; i < rows; i++){
            if (grid[i][0] == 0){
                for (int j = 0; j < cols; j++){
                    grid[i][j] ^= 1;
                }
            }
        }
        int score = 0;
        
        for (int j = 1; j < cols; j++){
            int count0 = 0;
            int count1 = 0;
            for (int i = 0; i < rows; i++){
                if (grid[i][j] == 0)
                    count0++;
                else
                    count1++;
            }
            if (count0 > count1){
                for (int i = 0; i < rows; i++){
                grid[i][j] ^= 1;
                }
            }
        }
        // for (int i = 0; i < rows; i++){
        //     for (int j = 0; j < cols; j++){
        //         System.out.print(grid[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        for (int i = 0; i < rows;  i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == 1)
                    score += 1<<(cols - j - 1);
            }
        }
        return score;
    }
    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 0 } };
        MatScoreFlip ob = new MatScoreFlip();
        System.out.println(ob.matrixScore(grid));
        
    }

}
