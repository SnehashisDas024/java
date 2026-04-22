
import java.util.*;

public class HouseRobber {
  // Declaration statement
  // public int rob(int[] nums) {
  // int n = nums.length;
  // if (n == 1)
  // return nums[0];
  // if (n == 2)
  // return Math.max(nums[0], nums[1]);
  // int[] dp = new int[n];
  // dp[0] = nums[0];
  // dp[1] = nums[1];
  // for (int i = 2; i < n; i++) {
  // dp[i] = nums[i] + dp[i - 2];
  // }
  // return Math.max(dp[n - 1], dp[n - 2]);
  // }

  public int amount(int[] nums, int i, int[] dp) {
    if (i >= nums.length)
      return 0;
    if (dp[i] != -1)
      return dp[i];
    int take = nums[i] + amount(nums, i + 2, dp);
    int skip = amount(nums, i + 1, dp);
    dp[i] = Math.max(take, skip);
    return dp[i];
  }

  public int rob(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, -1);
    return amount(nums, 0, dp);
  }

  public int rob2(int[] nums) {
    int n = nums.length;
    if (n == 1)
      return nums[0];
    if (n == 2)
      return Math.max(nums[0], nums[1]);
    int[] dp = new int[n];
    int take, skip;
    dp[0] = nums[0];
    dp[1] = Math.max(dp[0], nums[1]);
    for (int i = 2; i < n; i++) {
      dp[i] = Math.max((dp[i - 1] + nums[i]), (dp[i - 2] + nums[i]));
    }
    return dp[n - 1];
  }

  // Main method to run on your computer
  public static void main(String[] args) {
    HouseRobber sol = new HouseRobber();

    int[] testCase = { 1, 2, 3, 1 };
    int result = sol.rob(testCase);

    System.out.println("Result: " + result);
  }
}
