package 数组;

class Solution1470 {
    public int[] shuffle(int[] nums, int n) {
        int length = nums.length;
        int[] result = new int[length];
        for (int i = 0; i < n; i++) {
            result[i * 2] = nums[i];
        }
        for (int i = n; i < length; i++) {
            result[(i-n) * 2 + 1] = nums[i];
        }
        return result;
    }
}