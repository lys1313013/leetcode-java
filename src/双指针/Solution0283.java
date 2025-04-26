package 双指针;

/**
 * 283. 移动零
 * https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution0283 {
    public void moveZeroes(int[] nums) {
        int j = 0; // 存储可以覆盖的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            nums[j++] = nums[i];
        }
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}