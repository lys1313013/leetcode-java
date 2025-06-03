package 数组.二维数组;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 */
class Solution0054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int sum = m * n;
        List<Integer> ans = new ArrayList<>(sum);
        // 现在往哪个方向走
        boolean right = true;
        boolean down = false;
        boolean left = false;
        boolean up = false;
        // 每个方向的边界是什么
        int rightBorder = n - 1;
        int downBorder = m - 1;
        int leftBorder = 0;
        int upBorder = 0;

        int i = 0;
        int j = 0;

        while (ans.size() < sum) {
            ans.add(matrix[i][j]);
            if (right) {
                if (j < rightBorder) {
                    j++;
                } else {
                    right = false;
                    down = true;
                    // 上边界+1
                    upBorder++;
                    i++;
                }
            } else if (down) {
                if (i < downBorder) {
                    i++;
                } else {
                    down = false;
                    left = true;
                    // 右边界收缩
                    rightBorder--;
                    j--;
                }
            } else if (left) {
                if (j > leftBorder) {
                    j--;
                } else {
                    left = false;
                    up = true;
                    // 下边界--
                    downBorder--;
                    i--;
                }
            } else {

                if (i > upBorder) {
                    i--;
                } else {
                    up = false;
                    right = true;
                    // 左边界++
                    leftBorder++;
                    j++;
                }
            }
        }

        return ans;
    }
}