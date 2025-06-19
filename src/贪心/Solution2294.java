package 贪心;

import java.util.Arrays;

/**
 * 2294. 划分数组使最大差为 K
 */
class Solution2294 {
    public int partitionArray(int[] nums, int k) {
        int result = 1;
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int start = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] - start > k) {
                result++;
                start = nums[i];
            }
        }
        return result;
    }
}