package 数组;

import java.util.HashSet;
import java.util.Set;

/**
 * 1007. 行相等的最少多米诺旋转
 * https://leetcode.cn/problems/minimum-domino-rotations-for-equal-row/description/?envType=daily-question&envId=2025-05-03
 */
class Solution1007_MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = Integer.MAX_VALUE;
        // 要保证能翻转成功,top[0]和bottoms[0]一定包含了目标值
        // 以top[0]或bottoms[0]为基底，遍历计算就能得出答案了
        Set<Integer> targetSet = new HashSet<>();
        targetSet.add(tops[0]);
        targetSet.add(bottoms[0]);
        for (int target : targetSet) {
            int topSum = 0;
            int botoomSum = 0;
            boolean flag = true;
            for (int j = 0; j < tops.length; j++) {
                if (tops[j] != target && bottoms[j] != target) {
                    flag = false;
                    break;
                } else {
                    if (tops[j] == target) {
                        topSum++;
                    }
                    if (bottoms[j] == target) {
                        botoomSum++;
                    }
                }
            }
            if (flag) {
                int item = tops.length - Math.max(topSum, botoomSum);
                result = Math.min(result, item);
            }
        }
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }
}