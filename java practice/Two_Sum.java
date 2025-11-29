// LeetCode Problem: https://leetcode.com/problems/two-sum/  Difficulty: Easy
// Tags: Array, Hash Table, Two Pointers

// LeetCode Problem: https://leetcode.com/problems/two-sum/  Difficulty: Easy
// Tags: Array, Hash Table, Two Pointers

public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        int r[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    r[0] = i;
                    r[1] = j;
                    return r;
                }
            }
        }
        return new int[0]; // return empty array if no solution found
    }

    public static void main(String[] args) {
        Two_Sum solution = new Two_Sum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}