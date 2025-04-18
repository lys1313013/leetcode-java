package 数学;

import java.util.HashMap;
import java.util.Map;

/**
 * 2364. 统计坏数对的数目
 * https://leetcode.cn/problems/count-number-of-bad-pairs/description/?envType=daily-question&envId=2025-04-18
 *
 * 主要考点在于公式换算和计数
 */
class Solution2364 {
    /**
     * 1. 公式转换： j - i != nums[j] - nums[i] ==> nums[j] - j != nums[i] - i
     * 2. 遍历nums, 计算每一个num[i] - i 的值，存入map中
     * 例如 4,1,3,3
     * 计算索引0的时候，key = 4 sum+0, 计算索引1的时候， key = 0 sum+1,
     * 计算索引2的时候，key = 1 sum+2, 计算索引3的时候， key = 0 命中1. sum + 3 - 1
     */
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int key = i - nums[i];
            Integer count = map.getOrDefault(key, 0);
            sum = sum - count + i;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return sum;
    }
}