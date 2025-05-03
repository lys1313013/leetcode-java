package 哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked
 * #前缀和 #哈希表
 *
 */
class Solution0560_subarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>(n + 1);
        for (int sj : preSum) {
            // 如果存在sj - k的数，也就是说存在某几种可能，从i 开始遍历，遍历的某个位置时，等于sj - k
            // 即 从 该位置开始 遍历到当前位置等于k。因为 sj - k 等于那个数
            ans += cnt.getOrDefault(sj - k, 0);
            cnt.merge(sj, 1, Integer::sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution0560_subarraySumEqualsK solution = new Solution0560_subarraySumEqualsK();
        int[] nums = {1, -1, 2, -2};
        int k = 0;
        System.out.println(solution.subarraySum(nums, k));
    }
}