package 临时;

class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        /*
         * 
         * 
         * 
         * 
         *
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         */
        int max = 0;
        int n = startTime.length;
        // 算出每两个会议室之间的空闲时间
        int[] freeTime = new int[n + 1];
        freeTime[0] = startTime[0] - 0;
        for (int i = 1; i < n; i++) {
            freeTime[i] = startTime[i] - endTime[i - 1];
        }
        freeTime[n] = eventTime - endTime[n - 1];

        // 首次的值
        int sum = 0;
        for (int i = 0; i < k + 1; i++) {
            sum += freeTime[i];
        }
        max = Math.max(sum, max);

        // 后续只要加上这次遍历的，减去之前被算进去的第一个元素就是相邻的k+1个空闲时间之间的和
        for (int i = k + 1; i < n + 1; i++) {
            sum = sum - freeTime[i - k - 1] + freeTime[i];
            max = Math.max(sum, max);
        }

        return max;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        //输入：eventTime = 5, k = 1, startTime = [1,3], endTime = [2,5]
        //
        //输出：2©leetcode
        int[] startTime1 = { 1, 3 };
        int[] endTime1 = { 2, 5 };
        System.out.println(solution.maxFreeTime(5, 1, startTime1, endTime1));


        // 输入：eventTime = 10, k = 1, startTime = [0,2,9], endTime = [1,4,10]
        //
        //输出：6
        int[] startTime2 = { 0, 2, 9 };
        int[] endTime2 = { 1, 4, 10 };
        System.out.println(solution.maxFreeTime(10, 1, startTime2, endTime2));

        //输入：eventTime = 5, k = 2, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]
        //
        //输出：0
        int[] startTime3 = { 0, 1, 2, 3, 4 };
        int[] endTime3 = { 1, 2, 3, 4, 5 };
        System.out.println(solution.maxFreeTime(5, 2, startTime3, endTime3));


        // eventTime = 34 k = 2 startTime = [0,17] endTime =[14,19]
        // 预期 18
        int[] startTime4 = { 0, 17 };
        int[] endTime4 = { 14, 19 };
        System.out.println(solution.maxFreeTime(34, 2, startTime4, endTime4));


    }
}