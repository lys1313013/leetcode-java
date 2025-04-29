package 滑动窗口;

import java.util.ArrayList;
import java.util.List;

/**
 * 2962. 统计最大元素出现至少 K 次的子数组
 * https://leetcode.cn/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/?envType=daily-question&envId=2025-04-29
 * #滑动窗口 #排列组合
 * 例如，计算1,2,2,1 有几个包含两个2的场景
 * 组合为：[1,2,2],[1,2,2,1],[2,2],[2,2,1]
 * 计算方式为，（1 - （-1）） * ( 4 - 2)
 *            第一个2出现的位置 - （-1） * 总数 - 第二个2出现的位置
 */
class Solution2962 {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        List<Integer> maxIndexList = new ArrayList<>();
        maxIndexList.add(-1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                maxIndexList.add(i);
            }
        }
        //  maxIndexList集合中 left和right之间一定有k个max
        int left = 1, right = k;
        long sum = 0;
        while (right < maxIndexList.size()) {
            // 两边的变化相乘，乘数最小也为1
            // maxIndexList.get(left) - maxIndexList.get(left - 1) 计算左边有几个数
            // nums.length - maxIndexList.get(right) 算出右边有几个数
            sum += (long) (maxIndexList.get(left) - maxIndexList.get(left - 1)) * (nums.length - maxIndexList.get(right));

            left++;
            right++;
        }
        return sum;
    }

    public static void main(String[] args) {
        // nums = [1,3,2,3,3], k = 2
        Solution2962 solution = new Solution2962();
        int[] nums = {1,3,2,3,3};
        int k = 2;
        System.out.println(solution.countSubarrays(nums, k));
    }
}