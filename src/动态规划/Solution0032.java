package 动态规划;

/**
 * 32. 最长有效括号
 */
class Solution0032 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        char[] cs = s.toCharArray();
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (i - dp[i - 1] - 1 >= 0) {
                if (')' == cs[i] && cs[i - dp[i - 1] - 1] == '(') {
                    if (i - dp[i - 1] - 2 >= 0) {
                        dp[i] = 2 + dp[i - 1] + dp[i - dp[i - 1] - 2];
                    } else {
                        dp[i] = 2 + dp[i - 1];
                    }

                }
            } else if (')' == cs[i] && '(' == cs[i]) {
                dp[i] = 2;
            }
            max = Math.max(max, dp[i]);

        }
        return max;
    }
}