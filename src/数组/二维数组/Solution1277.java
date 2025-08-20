package 数组.二维数组;

/**
 * 1277. 统计全为 1 的正方形子矩阵
 */
class Solution1277 {
    public int countSquares(int[][] matrix) {
        int sum = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                sum++;
                if (i >= 1 && j >= 1 && matrix[i - 1][j - 1] > 0) {
                    int min = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1]));
                    sum += min;
                    matrix[i][j] = min + 1;
                }

            }
        }
        return sum;
    }
}