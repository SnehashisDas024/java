import java.util.Arrays;

public class SubsetSum {
  public static void main(String[] args) {
    int[] nums = { 0, 8, 5, 2, 3 };
    int target = 9;
    SubsetSum ob = new SubsetSum();
    int[][] dp = new int[nums.length][target + 1];
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], -1);
    }
    int result = ob.getdec(0, nums, target, dp);
    System.out.println(result);
  }

  public int getdec(int i, int[] nums, int target, int[][] dp) {
    if (target == 0)
      return 1;
    if (i == nums.length)
      return 0;
    if (dp[i][target] != -1)
      return dp[i][target];
    int skip = getdec(i + 1, nums, target, dp);
    if (nums[i] > target)
      return dp[i][target] = skip;
    int take = getdec(i + 1, nums, target - nums[i], dp);
    if (take == 1 || skip == 1)
      return dp[i][target] = 1;
    return dp[i][target] = 0;
  }
}
