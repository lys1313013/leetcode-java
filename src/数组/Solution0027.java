package 数组;

/**
 * 27. 移除元素
 * https://leetcode.cn/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
 */
class Solution0027 {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}