package 数组.二维数组;

import java.util.Arrays;

class Solution1706 {
    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];
        for (int i = 0; i < result.length; i++) {
            int ballY = i;
            // j 代表行数
            int j = 0;
            for (; j < grid.length; j++) {
                if (grid[j][ballY] == 1) {
                    if (ballY == result.length - 1) {
                        result[i] = -1;
                        break;
                    } else if (grid[j][ballY + 1] == -1) {
                        result[i] = -1;
                        break;
                    } else {
                        ballY++;
                        continue;
                    }
                }
                if (grid[j][ballY] == -1) {
                    if (ballY == 0) {
                        result[i] = -1;
                        break;
                    } else if (grid[j][ballY - 1] == 1) {
                        result[i] = -1;
                        break;
                    } else {
                        ballY--;
                        continue;
                    }
                }
            }
            if (j == grid.length) {
                result[i] = ballY;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 输入：grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
        //输出：[1,-1,-1,-1,-1]
        int[][] grid = {
                {1, 1, 1, -1, -1},
                {1, 1, 1, -1, -1},
                {-1, -1, -1, 1, 1},
                {1, 1, 1, 1, -1},
                {-1, -1, -1, -1, -1}
        };
        Solution1706 solution1706 = new Solution1706();
        int[] ints = solution1706.findBall(grid);
        System.out.println(Arrays.toString(ints));

        // 输入：grid = [[-1]]
        //输出：[-1]
        int[][] grid2 = {
                {-1}
        };
        int[] ints2 = solution1706.findBall(grid2);
        System.out.println(Arrays.toString(ints2));


        // 输入：grid = [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]
        //输出：[0,1,2,3,4,-1]
        int[][] grid3 = {
                {1, 1, 1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1},
                {1, 1, 1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1}
        };
        int[] ints3 = solution1706.findBall(grid3);
        System.out.println(Arrays.toString(ints3));

    }
}