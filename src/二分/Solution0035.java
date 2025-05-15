package 二分;

/**
 * 35. 搜索插入位置
 */
class Solution0035 {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                 right = mid - 1;
            }
        }
        return left;
    }
}