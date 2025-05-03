package 动态规划;

/**
 * 42. 接雨水
 * https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked
 * 动态规划 计算右边的最大值
 * dp[i] = Math.max(dp[i + 1], height[i+1])
 */
class Solution0042_trappingRainWater {
    public int trap(int[] height) {
        // 找到当前列左边和右边的最大值，取其最小值 - 当前列，就是当前列能存放的雨水数
        int leftMax = 0;
        int sum = 0;
        int n = height.length;
        int[] rightMaxs = new int[n];
        // rightMaxs存储每个数右边的最大值
        rightMaxs[n - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            rightMaxs[i] = Math.max(height[i+1], rightMaxs[i+1]);
        }

        for (int i = 0; i < height.length; i++) {

            int rightMax = rightMaxs[i];
            if (leftMax > height[i] && rightMax > height[i]) {
                int min = Math.min(leftMax, rightMax);
                sum += min - height[i];
            }

            leftMax = Math.max(leftMax, height[i]);
        }
        return sum;
    }
}