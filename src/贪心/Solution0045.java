package 贪心;

class Solution0045 {
    public int jump(int[] nums) {
        if (nums[0] == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 0;
        }
        // 贪心
        // 1.先判断能不能直接跳到终点
        // 2.否则判断跳到哪一格最划算 nums[i] + i
        int sum = 0;
        int length = nums.length;
        for (int i = 0; i < nums.length; ) {
            sum++;
            if (nums[i] + i >= length - 1) {
                return sum;
            }
            int maxIndex = i + 1;
            for (int j = i + 1; j <= i + nums[i] ; j++) {
                if (nums[j] + j > nums[maxIndex] + maxIndex) {
                    maxIndex = j;
                }
            }
            i = maxIndex;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution0045 solution = new Solution0045();
        int[] nums = {2,3,1,1,4};
        System.out.println(solution.jump(nums));
    }
}