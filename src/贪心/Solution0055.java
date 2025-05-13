package 贪心;

/**
 * 55. 跳跃游戏
 */
class Solution0055 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(nums[i] + i, max);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}