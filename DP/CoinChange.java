import java.util.Arrays;

public class CoinChange {
  public static void main(String[] args) {

    // Test Case 1
    int[] coins1 = { 1, 2, 5 };
    int amount1 = 11; // Expected: 3 (5+5+1)

    // Test Case 2
    int[] coins2 = { 2 };
    int amount2 = 3; // Expected: -1

    // Test Case 3
    int[] coins3 = { 1 };
    int amount3 = 0; // Expected: 0

    // Test Case 4
    int[] coins4 = { 1 };
    int amount4 = 2; // Expected: 2

    // Test Case 5
    int[] coins5 = { 2, 5, 10, 1 };
    int amount5 = 27; // Expected: 4 (10+10+5+2)

    // Test Case 6
    int[] coins6 = { 186, 419, 83, 408 };
    int amount6 = 6249; // Expected: 20

    // Test Case 7
    int[] coins7 = { 3, 7 };
    int amount7 = 5; // Expected: -1

    // Test Case 8
    int[] coins8 = { 1, 3, 4 };
    int amount8 = 6; // Expected: 2 (3+3)

    // Test Case 9
    int[] coins9 = { 5, 7, 8 };
    int amount9 = 15; // Expected: 2 (7+8)

    // Test Case 10
    int[] coins10 = { 2, 4, 6 };
    int amount10 = 8; // Expected: 2 (4+4)

    // Replace 'coinChange' with your function call
    CoinChange obj = new CoinChange();

    System.out.println(obj.coinChange(coins1, amount1));
    System.out.println(obj.coinChange(coins2, amount2));
    System.out.println(obj.coinChange(coins3, amount3));
    System.out.println(obj.coinChange(coins4, amount4));
    System.out.println(obj.coinChange(coins5, amount5));
    System.out.println(obj.coinChange(coins6, amount6));
    System.out.println(obj.coinChange(coins7, amount7));
    System.out.println(obj.coinChange(coins8, amount8));
    System.out.println(obj.coinChange(coins9, amount9));
    System.out.println(obj.coinChange(coins10, amount10));
  }

  public int coinChange(int[] coins, int amt) {
    if (amt == 0)
      return 0;
    int[][] dp = new int[coins.length][amt + 1];
    for (int i = 0; i < coins.length; i++) {
      Arrays.fill(dp[i], -2);
    }
    Arrays.sort(coins);
    for (int i = 0; i < coins.length / 2; i++) {
      int temp = coins[i];
      coins[i] = coins[coins.length - 1 - i];
      coins[coins.length - 1 - i] = temp;
    }
    return coinVal(0, coins, amt, dp);
  }

  public int coinVal(int i, int[] coins, int amt, int[][] dp) {
    if (amt == 0)
      return 0;
    if (i == coins.length)
      return -1;
    if (dp[i][amt] != -2)
      return dp[i][amt];
    int skip = coinVal(i + 1, coins, amt, dp);
    int pick = -1;

    if (coins[i] <= amt) {
      int next = coinVal(i, coins, amt - coins[i], dp);
      if (next != -1)
        pick = 1 + next;
    }

    if (pick == -1)
      return dp[i][amt] = skip;

    if (skip == -1)
      return dp[i][amt] = pick;

    return dp[i][amt] = Math.min(pick, skip);
  }
}
