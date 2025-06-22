package 数组.二维数组;

import java.util.Arrays;

/**
 * 3588. 找到最大三角形面积
 */
class Solution3588 {
    public long maxArea(int[][] coords) {
        long ans = calMaxArea(coords);
        // 互换坐标,复用calMaxArea方法
        for (int[] coord : coords) {
            int temp = coord[0];
            coord[0] = coord[1];
            coord[1] = temp;
        }
        return Math.max(ans, calMaxArea(coords));
    }

    public long calMaxArea(int[][] coords) {
        Arrays.sort(coords, (a,b) -> {
            if ((a[0] != b[0])) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        int n = coords.length;
        long ans = -1;
        for (int i = 0; i < n; i++) {
            int[] coord1 = coords[i];
            // 基底的最大值
            long max1 = 0;
            // 高的最大值
            long max2 = 0;
            // 因为排序了，只需要考虑最左的坐标和最右的坐标
            max2 = Math.max(max2, Math.abs(coords[0][0] - coord1[0]));
            max2 = Math.max(max2, Math.abs(coords[n - 1][0] - coord1[0]));

            for (int j = i + 1; j < n; j++) {
                int[] coord2 = coords[j];
                if (coord2[0] == coord1[0]) {
                    max1 = Math.max(max1, coord2[1] - coord1[1]);
                } else {
                    break;
                }
            }
            if (max1 != 0 && max2 != 0) {
                ans = Math.max(ans, max1 * max2);
            }
        }
        return ans;
    }
}