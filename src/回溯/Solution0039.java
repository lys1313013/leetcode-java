package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 */
class Solution0039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        backtrack(target, candidates, ans, t, 0, 0);
        return ans;
    }

    public void backtrack(int target, int[] candidates, List<List<Integer>> ans, List<Integer> t, int sum, int cur) {
        if (sum == target) {
            ans.add(new ArrayList(t));
            return;
        } else if (sum > target) {
            return;
        } else {
            for (int i = cur; i < candidates.length; i++) {
                t.add(candidates[i]);
                backtrack(target, candidates, ans, t, sum + candidates[i], i);
                t.remove(t.size() - 1);
            }
        }
    }
}