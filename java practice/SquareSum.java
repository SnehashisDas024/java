//LeetCode 633. Sum of Square Numbers
// Link: https://leetcode.com/problems/sum-of-square-numbers/

public class SquareSum {
    public static void main(String[] args) {
        SquareSum sol = new SquareSum();
        int c = 5;
        boolean result = sol.judgeSquareSum(c);
        System.out.println(result); // Output: true
    }
    public boolean judgeSquareSum(int n){
        int l = (int)Math.sqrt(n);
        for (int i = 0; i <= l; i++){
            if (Math.sqrt(n-(i*i)) == (int)Math.sqrt(n-(i*i))){
                return true;
            }
        }
        return false;
    }
}