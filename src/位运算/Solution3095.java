package 位运算;

class Solution3095 {
    public int minimumSubarrayLength(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int orValue = 0;
            for (int j = i; j < nums.length; j++) {
                orValue |= nums[j];
                if (orValue >= k) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    public static void main(String[] args) {
        // [2,1,8] k = 10
        int[] nums = { 2, 1, 8 };
        int k = 10;
        System.out.println(new Solution3095().minimumSubarrayLength(nums, k));

    }
}