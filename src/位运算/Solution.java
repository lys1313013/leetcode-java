package 位运算;

import java.util.Arrays;

/**
 * 3514. 不同 XOR 三元组的数目 II
 * https://leetcode.cn/problems/number-of-unique-xor-triplets-ii/description/
 *
 * 待学习
 */
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int mx = 0;
        // 找到数组中的最大值
        for (int x : nums) {
            mx = Math.max(mx, x);
        }

        // f：保存两个数异或起来可能有哪些结果
        // g：保存三个数异或起来可能有哪些结果
        boolean[] f = new boolean[mx * 2 + 1];
        boolean[] g = new boolean[mx * 2 + 1];
        Arrays.fill(f, false);
        Arrays.fill(g, false);

        // 首先枚举两个数异或起来的可能结果
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                f[nums[i] ^ nums[j]] = true;
            }
        }

        // 然后枚举三个数异或起来的可能结果
        for (int i = 0; i <= mx * 2; i++) {
            if (f[i]) {
                for (int x : nums) {
                    g[i ^ x] = true;
                }
            }
        }

        // 统计三个数异或结果的总数
        int ans = 0;
        for (int i = 0; i <= mx * 2; i++) {
            if (g[i]) {
                ans++;
            }
        }

        return ans;
    }
}
