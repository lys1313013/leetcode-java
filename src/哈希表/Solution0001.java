package 哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1. 两数之和
 * https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution0001 {
    public int[] twoSum(int[] nums, int target) {
        // 通过哈希表将时间复杂度控制在O(n)
        // 遍历时，将nums[i]的值作为可以存储在哈希表中，只要存在 target - nums[i]的 key（不包含本身），就说明找到值了，直接return
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // set转数组
        Integer[] array = set.toArray(new Integer[0]);

        return new int[]{};
    }
}