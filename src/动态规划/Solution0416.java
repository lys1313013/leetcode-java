package 动态规划;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 */
class Solution0416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        Arrays.sort(nums);
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = target; j >= num; j--) {
                if (dp[j - num]) {
                    dp[j] = true;
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution0416 solution = new Solution0416();
        boolean b = solution.canPartition(new int[]{1, 5, 11, 5});
    }
}