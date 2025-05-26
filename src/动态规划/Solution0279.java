package 动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * 279. 完全平方数
 */
class Solution0279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        List<Integer> pingfangshu = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            dp[i] = n + 1;

            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                dp[i] = 1;
                pingfangshu.add(i);
            } else {
                for (int j = 0; j < pingfangshu.size(); j++) {
                    if (i - pingfangshu.get(j) > 0) {
                        dp[i] = Math.min(dp[i - pingfangshu.get(j)] + 1, dp[i]);
                    }

                }

            }
        }
        return dp[n];
    }
}