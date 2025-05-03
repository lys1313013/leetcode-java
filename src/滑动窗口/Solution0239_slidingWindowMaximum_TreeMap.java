package 滑动窗口;

import java.util.TreeMap;

/**
 * 239. 滑动窗口最大值
 * https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=top-100-liked
 * 强行做成了TreeMap，主要是为了获取最大值。。。
 */
class Solution0239_slidingWindowMaximum_TreeMap {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 入
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
            if (i < k - 1) {
                continue;
            }

            if (i >= k) {
                // 出
                int value = treeMap.get(nums[i - k]);
                if (value == 1) {
                    treeMap.remove(nums[i - k]);
                } else {
                    treeMap.put(nums[i - k], value - 1);
                }
            }

            // 计算结果
            ans[i - k + 1] = treeMap.lastKey();
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution0239_slidingWindowMaximum_TreeMap solution = new Solution0239_slidingWindowMaximum_TreeMap();
        int[] ints = solution.maxSlidingWindow(new int[]{1, -1}, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}