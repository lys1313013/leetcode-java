package 位运算;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode.cn/problems/subsets/description/?envType=daily-question&envId=2025-02-05
 */
class Solution0078 {

    public List<List<Integer>> subsets(int[] nums) {
        // 位运算
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        // 第一层循环控制每次选中的数据
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> temp = new ArrayList<>();
            // 第二层循环将匹配中的数据塞入集合中
            for (int i = 0; i < n; i++) {
                // 位运算优先级太低，使用括号包裹
                if ((mask & (1 << i)) != 0) {
                    temp.add(nums[i]);
                }
            }
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution0078 solution0078 = new Solution0078();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = solution0078.subsets(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}