package 回溯;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 */
class Solution0046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int start) {
        if (start == n) {
            System.out.println("收：" + output);
            res.add(new ArrayList<>(output));
        }
        for (int i = start; i < n; i++) {
            Collections.swap(output, start, i);
            System.out.printf("交换：first:%s,i:%s, output: %s%n", start, i, output);
            backtrack(n, output, res, start + 1);
            Collections.swap(output, start, i);
            System.out.printf("复原:first:%s,i:%s, output: %s%n", start, i, output);
        }
    }

    public static void main(String[] args) {
        Solution0046 solution = new Solution0046();
        int[] nums = new int[]{1, 2, 3};
        solution.permute(nums);
    }
}