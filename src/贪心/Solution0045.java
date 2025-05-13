package 贪心;

/**
 * 45. 跳跃游戏 II
 */
class Solution0045 {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < nums.length;) {
            if (i + nums[i] >= nums.length - 1) {
                return sum + 1;
            }

            int maxValue = 0;
            int maxIndex = 0;
            for (int j = 1; j <= nums[i]; j++) {
                
                if (j + nums[i + j] > maxValue) {
                    maxValue = j + nums[i + j];
                    maxIndex = j;
                }
            }
            i += maxIndex;
            sum++;
        }
        return sum;

    }
}