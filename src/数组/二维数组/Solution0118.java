package 数组.二维数组;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 */
class Solution0118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int[][] nums = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // 开头和结尾都是1
                if (j == 0 || j == i) {
                    nums[i][j] = 1;
                } else {
                    nums[i][j] = nums[i - 1][j - 1] + nums[i - 1][j];
                }
                temp.add(nums[i][j]);
            }
            result.add(temp);
        }
        return result;
    }
}