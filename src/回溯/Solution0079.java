package 回溯;

/**
 * 79. 单词搜索
 */
class Solution0079 {
    public boolean exist(char[][] board, String word) {
        char[] cs = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backtrack(board, cs, 0, i, j)) {
                    return true;
                }

            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, char[] cs, int index, int i, int j) {
        if (index == cs.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) {
            return false;
        }

        if (board[i][j] == cs[index]) {
            char c = board[i][j];
            board[i][j] = '\0';
            if (backtrack(board, cs, index + 1, i - 1, j) || backtrack(board, cs, index + 1, i + 1, j)
                    || backtrack(board, cs, index + 1, i, j - 1) || backtrack(board, cs, index + 1, i, j + 1)) {
                return true;
            }
            board[i][j] = c;
        }
        return false;

    }
}