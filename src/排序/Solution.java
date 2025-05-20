package 排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        // 根据第一个数字排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (list.isEmpty()) {
                // 如果空，就加入
                list.add(interval);
            } else {
                int[] pre = list.get(list.size() - 1);
                // 如果前面的后一个数字和后面的前一个数字有重叠，则合并
                if (pre[1] >= interval[0]) {
                    if (pre[1] < interval[1]) {
                        pre[1] = interval[1];
                    }
                } else {
                    list.add(interval);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}