package 动态规划;

import java.util.Arrays;

/**
 * 198. 打家劫舍
 */
class Solution0198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        } 
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }
}