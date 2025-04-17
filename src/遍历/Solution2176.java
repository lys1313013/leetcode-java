package 遍历;

/**
 * 2176. 统计数组中相等且可以被整除的数对
 * https://leetcode.cn/problems/count-equal-and-divisible-pairs-in-an-array/description/?envType=daily-question&envId=2025-04-17
 */
class Solution2176 {
    public int countPairs(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    sum++;
                }
            }
        }
        return sum;
    }
}