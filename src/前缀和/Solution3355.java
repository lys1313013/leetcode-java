package 前缀和;

/**
 * 3355. 零数组变换 I
 * 前缀和
 */
class Solution3355 {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] deltaArray = new int[nums.length + 1];
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            deltaArray[left] += 1;
            deltaArray[right + 1] -= 1;
        }       
        int[] operationCounts = new int[deltaArray.length];
        int currentOperations = 0;
        for (int i = 0; i < deltaArray.length; i++) {
            currentOperations += deltaArray[i];
            operationCounts[i] = currentOperations;
        }
        for (int i = 0; i < nums.length; i++) {
            if (operationCounts[i] < nums[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution3355 solution = new Solution3355();
        int[] nums = {4, 3, 2, 1};
        int[][] queries = {{1,3}, {0,2}};
        boolean result = solution.isZeroArray(nums, queries);
    }
}