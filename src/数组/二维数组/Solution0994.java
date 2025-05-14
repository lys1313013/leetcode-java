package 数组.二维数组;

/**
 * 994. 腐烂的橘子
 */
class Solution0994 {
    public int orangesRotting(int[][] grid) {
        int sum = 0;
        boolean flag = true;
        int m = grid.length;
        int n = grid[0].length;
        while (flag) {
            flag = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        grid[i][j] = 0;
                        if (i - 1 >= 0) {
                            if (grid[i - 1][j] == 1) {
                                grid[i - 1][j] = 3;
                                flag = true;
                            }
                        }
                        if (i + 1 < m) {
                            if (grid[i + 1][j] == 1) {
                                grid[i + 1][j] = 3;
                                flag = true;
                            }
                        }
                        if (j - 1 >= 0) {
                            if (grid[i][j - 1] == 1) {
                                grid[i][j - 1] = 3;
                                flag = true;
                            }
                        }
                        if (j + 1 < n) {
                            if (grid[i][j + 1] == 1) {
                                grid[i][j + 1] = 3;
                                flag = true;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 3) {
                        grid[i][j] = 2;
                    }
                }
            }
            if (flag == false) {
                break;
            }
            sum++;
        }

        // 判断还有没有烂橘子
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return sum;
    }
}