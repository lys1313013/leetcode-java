package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 */
class Solution0078 {
    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        // 先把自己放进去，再把自己移除，以此实现，所有组合的遍历
        t.add(nums[cur]);
        // 有当前值的场景
        dfs(cur + 1, nums);
        // 移除当前值
        t.remove(t.size() - 1);
        // 没有当前值的场景
        dfs(cur + 1, nums);
    }

    /*
nums = [1,2,3]

入栈 cur = 0,t = [1]
	入栈 cur = 1, t = [1,2]
		入栈 cur = 2,t = [1,2,3]
			入栈 cur = 3 得到 [1,2,3]
			结束
		移除3 t = [1,2]
			入栈 cur = 3 得到 [1,2]
			结束
		结束
	移除2 t=[1]
		入栈 cur = 2, t = [1,3]
			入栈 cur = 3
			得到 [1,3]
			结束
		移除3 t = [1]
			入栈 cur = 3
			得到 [1]
			结束
		结束
	结束

移除1 []
	入栈cur = 1
	t = [2]
		入栈cur = 2
		t = [2,3]
			入栈 cur = 3
			得到 [2,3]
			结束
		移除3 t = [2]
			入栈 cur = 2
			得到 [2]
			结束
		结束
	移除2 t = []
		入栈cur = 3
		t = [3]
			入栈 cur = 3
			得到 [3]
			结束
		移除3 t = []
			入栈 cur = 3
			得到 []
			结束
		结束
	结束
结束
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution0078().subsets(nums));
    }
}