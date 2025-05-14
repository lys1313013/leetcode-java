package 回溯;

/**
 * 200. 岛屿数量
 */
class Solution0200 {
    public int numIslands(char[][] grid) {
        int sum = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    sum++;
                    // 找与之相连的陆地
                    backtrack(grid, i, j);
                }
            }
        }
        return sum;
    }

    public void backtrack(char[][] grid, int i, int j) {
        if (i < 0 || grid.length <= i) {
            return;
        } else if (j < 0 || grid[0].length <= j) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            backtrack(grid, i - 1, j);
            backtrack(grid, i, j - 1);
            backtrack(grid, i + 1, j);
            backtrack(grid, i, j + 1);
        }
    }
}