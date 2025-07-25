package 贪心;

import java.util.HashSet;
import java.util.Set;

/**
 * 3487. 删除后的最大子数组元素和
 */
class Solution3487 {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            if (num > 0) {
                if (!set.contains(num)) {
                    set.add(num);
                    sum += num;
                }
            }
        }
        if (max < 0) {
            return max;
        } else {
            return sum;
        }
    }
}