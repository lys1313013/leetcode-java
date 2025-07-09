package 滑动窗口;

/**
 * 3439. 重新安排会议得到最多空余时间 I
 */
class Solution3439 {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        /*
         * 解法其实就是求出每两个时间段之间的空闲时间塞进数组里，然后求出k+1个相邻空闲时间之和中最大的那一个
         * int[]freeTime 为两个会议之间的空闲时间
         * freeTime[0]为0到startTime[0]的时间
         * startTime[startTime.length]为 endTime[startTime.length - 1] 到 eventTime的时间
         *
         * 例如:
         * 示例1：
         * eventTime = 5, k = 1, startTime = [1,3], endTime = [2,5] 时
         * freeTime [1, 1, 0] k等于1，取2个值的和
         * 示例2：
         * eventTime = 10, k = 1, startTime = [0,2,9], endTime = [1,4,10]
         * freeTime [0, 1, 5, 0] k等于1，取2个值的和
         * 示例3：
         * eventTime = 5, k = 2, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]
         * freeTime [0, 0, 0, 0, 0, 0] k等于2 取3个值的和
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
}