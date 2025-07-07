package 贪心;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1353. 最多可以参加的会议数目
 */
class Solution1353 {
    public int maxEvents(int[][] events) {
        int n = events.length;
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }

        // 按照开始时间升序排序
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        // 小顶堆，维护最小的endDay
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;
        for (int currentDay = 1, j = 0; currentDay <= maxDay; currentDay++) {
            // 将所有开始时间等于currentDay的会议加入小顶堆
            while (j < n && events[j][0] <= currentDay) {
                pq.offer(events[j][1]);
                j++;
            }
            // 删除过期的会议
            while (!pq.isEmpty() && pq.peek() < currentDay) {
                pq.poll();
            }
            // 选择结束时间最小的会议参加
            if (!pq.isEmpty()) {
                // 参加的会议，就从堆中删除
                pq.poll();
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1353 solution = new Solution1353();
        int[][] events = {{1, 2}, {1, 3}};
        int result = solution.maxEvents(events);
    }
}