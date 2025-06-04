package 数组.二维数组;

/**
 * 48. 旋转图像
 */
class Solution0048 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int maxIndex = n - 1;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[j][maxIndex - i];
                matrix[j][maxIndex - i] = matrix[i][j];
                matrix[i][j] = matrix[maxIndex- j][i];
                matrix[maxIndex - j][i] = matrix[maxIndex- i][maxIndex- j];
                matrix[maxIndex- i][maxIndex - j] = temp;
            }
        }
    }
}