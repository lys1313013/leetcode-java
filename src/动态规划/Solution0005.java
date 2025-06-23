package 动态规划;

/**
 * 5. 最长回文子串
 */
class Solution0005 {
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 标识s[i..j]是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化，所有长度为1的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        for (int j = 0; j < len; j++) {
            char c1 = charArray[j];
            for (int i = 0; i < j; i++) {
                char c2 = charArray[i];
                if (c1 == c2) {
                    if (j - i <= 2) {
                        // 如果相邻
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}