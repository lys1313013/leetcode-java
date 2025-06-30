package 排序;

import java.util.Arrays;

/**
 * 31. 下一个排列
 */
class Solution0031 {
    public void nextPermutation(int[] nums) {
        // 找到比当前小的数，调整左边是最小的数据
        int n = nums.length;
        
        int rightIndex = -1;
        int maxLeftIndex = -1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (maxLeftIndex < j) {
                        maxLeftIndex = j;
                        rightIndex = i;
                    }
                }
            }
        } 
        if (maxLeftIndex == -1) {
            Arrays.sort(nums);
            return;
        }

        // 调整最左边的位置
        int temp = nums[maxLeftIndex];
        nums[maxLeftIndex] = nums[rightIndex];
        nums[rightIndex] = temp;
        
        // 最左边往后进行排序,冒泡
        for (int i = 1; i < n - maxLeftIndex + 1 ; i++) {
            for (int j = maxLeftIndex + 1; j < n - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                }
            }
        } 
    }
}