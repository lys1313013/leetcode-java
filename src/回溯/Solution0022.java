package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 */
class Solution0022 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(ans, sb, n, 0, 0);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder sb, int target, int open, int close) {
        if (sb.length() == target * 2) {
            ans.add(sb.toString());
            return;
        }
        if (open < target) {
            sb.append("(");
            backtrack(ans, sb, target, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            backtrack(ans, sb, target, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}