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
                // 判断是否有其他的正方向
                int ii = i - 1;
                int jj = j - 1;
                if (ii >= 0 && jj >= 0 && matrix[ii][jj] > 0) {
                    int size = matrix[ii][jj];
                    int upSize = 0;
                    int leftSize = 0;
                    for (int iii = i - 1; iii >= i - size; iii--) {
                        if (matrix[iii][j] == 0) {
                            break;
                        }
                        upSize++;
                    }
                    for (int jjj = j - 1; jjj >= j - size; jjj--) {
                        if (matrix[i][jjj] == 0) {
                            break;
                        }
                        leftSize++;
                    }
                    sum += Math.min(upSize, leftSize);
                    matrix[i][j] = Math.min(upSize, leftSize) + 1;
                }

            }
        }
        return sum;
    }
}