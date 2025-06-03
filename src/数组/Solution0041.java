package 数组;

/**
 * 41. 缺失的第一个正数
 */
class Solution0041 {
    public int firstMissingPositive(int[] nums) {
        // 1. 对于n长度的数组，缺失的数字一定在n+1中
        // 2. 遍历数组，将小于等于0的数赋值为1，如果1存在的话
        int n = nums.length;
        boolean oneFlag = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                oneFlag = false;
            } else if (nums[i] <= 0) {
                nums[i] = 1;
            }
        }
        if (oneFlag) {
            return 1;
        }

        // 3. 遍历数组，对nums[i] 值所在的索引 置为负数
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (index >= n) {
                continue;
            }
            nums[index] = - Math.abs(nums[index]);
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}