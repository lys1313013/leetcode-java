package 贪心;

import java.util.Arrays;

/**
 * 2966. 划分数组并满足最大差限制
 */
class Solution2966 {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] ans = new int[n / 3][3];
        for (int i = 0; i < n / 3; i++) {
            int n1 = nums[i * 3];
            int n2 = nums[i * 3 + 1];
            int n3 = nums[i * 3 + 2];
            if (n3 - n1 > k) {
                return new int[0][];
            }
            ans[i][0] = n1;
            ans[i][1] = n2;
            ans[i][2] = n3;
        }

        return ans;
    }
}