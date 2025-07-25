package 动态规划;

import java.util.Arrays;

/**
 * 1143. 最长公共子序列
 */
class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j < n + 1; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        for (int[] temp : dp) {
            System.out.println(Arrays.toString(temp));
        }
        return dp[m][n];
    }
}