package 滑动窗口;

import java.util.HashSet;
import java.util.Set;

/**
 * 1695. 删除子数组的最大得分
 */
class Solution1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int max = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0, j = 0; i < nums.length; i++) {
            sum += nums[i];
            while (set.contains(nums[i])) {
                set.remove(nums[j]);
                sum -= nums[j];
                j++;
            }
            set.add(nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}