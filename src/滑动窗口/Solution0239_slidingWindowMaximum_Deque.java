package 滑动窗口;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 * https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=top-100-liked
 * 单调队列
 */
class Solution0239_slidingWindowMaximum_Deque {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[]{};
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 删除deque 中对应的 nums[i - 1];
            if (i > 0 && deque.peekFirst() == nums[i - 1]) {
                // 移除第一个元素，也就是最大的元素
                deque.removeFirst();
            }
            // 保持deque递减
            while(!deque.isEmpty() && deque.peekLast() < nums[j]) {
                // 如果前面的元素中存在比当前元素小的，前面的元素就没有用了，因为当前的元素不仅大，还更后面，可以留的比较久
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            // 记录窗口最大值
            if (i >= 0) {
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution0239_slidingWindowMaximum_Deque solution = new Solution0239_slidingWindowMaximum_Deque();
        int[] ints = solution.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
    }
}
