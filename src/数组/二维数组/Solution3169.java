package 数组.二维数组;

import java.util.Arrays;

/**
 * 3169. 无需开会的工作日
 */
class Solution3169 {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        for (int[] temp : meetings) {
            System.out.println(Arrays.toString(temp));
        }
        int n = meetings.length;
        int result = 0;
        int start = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, meetings[i][1]);
            // 计算上一个结束和这一个开始的差值
            if (meetings[i][0] > start) {
                result += meetings[i][0] - start -1;
                start = meetings[i][1];
            } else {
                start = Math.max(start, meetings[i][1]);
            }
        }
        // 计算最后一个
        if (max < days) {
            result += days - max;
        }
        return result;
    }
}