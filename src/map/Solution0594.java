package map;

import java.util.HashMap;
import java.util.Map;

/**
 * 594. 最长和谐子序列
 */
class Solution0594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key : cnt.keySet()) {
            int value = cnt.get(key);
            if (cnt.containsKey(key + 1)) {
                max = Math.max(max, cnt.getOrDefault(key + 1, 0) + value);
            }
        }
        return max;
    }
}