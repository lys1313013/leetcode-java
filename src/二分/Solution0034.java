package 二分;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
class Solution0034 {
    public int[] searchRange(int[] nums, int target) {
        boolean flag = false;
        int n = nums.length;
        int right = n - 1;
        int left = 0;
        int midle = 0;
        while (left <= right) {
            midle = (left + right) / 2;
            if (nums[midle] == target) {
                flag = true;
                break;
            } else if (nums[midle] > target) {
                right = midle - 1;
            } else {
                left = midle + 1;

            }
        }

        if (flag == false) {
            return new int[] { -1, -1 };
        } else {
            // 中心往两边扩
            int min = midle;
            int max = midle;
            for (int i = min; i >= 0; i--) {
                if (nums[i] == target) {
                    min = i;
                } else {
                    break;
                }
            }
            for (int i = max; i < n; i++) {
                if (nums[i] == target) {
                    max = i;
                } else {
                    break;
                }
            }
            return new int[] { min, max };

        }

    }
}