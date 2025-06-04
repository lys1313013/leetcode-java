package 数组.二维数组;

/**
 * 240. 搜索二维矩阵 II
 */
class Solution0240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1;
        int j = 0;
        // 从左下角起步，target大于当前，就往右，小于就往上
        while (j < n && i >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}