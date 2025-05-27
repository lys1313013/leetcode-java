package 动态规划;

/**
 * 152. 乘积最大子数组
 */
class Solution0152 {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp1[0] = nums[0];
        dp2[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp1[i] = nums[i];
            dp2[i] = nums[i];

            if (nums[i] * dp1[i - 1] > dp1[i]) {
                dp1[i] = nums[i] * dp1[i - 1];
            }
            if (nums[i] * dp2[i - 1] > dp1[i]) {
                dp1[i] = nums[i] * dp2[i - 1];
            }

            if (nums[i] * dp2[i - 1] < dp2[i]) {
                dp2[i] = nums[i] * dp2[i - 1];
            }
            if (nums[i] * dp1[i - 1] < dp2[i]) {
                dp2[i] = nums[i] * dp1[i - 1];
            }
            max = Math.max(dp1[i], max);
            max = Math.max(dp2[i], max);
        }
        return max;
    }
}