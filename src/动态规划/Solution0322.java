package 动态规划;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 */
class Solution0322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        long[] dp = new long[amount + 1];
        Arrays.sort(coins);
        if (amount < coins[0]) {
            return -1;
        }

        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i == coins[j]) {
                    dp[i] = 1;
                } else if (i - coins[j] > 0 && dp[i - coins[j]] + 1 < dp[i]) {
                    dp[i] = dp[i - coins[j]] + 1;
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return (int) dp[amount];
        }
    }
}