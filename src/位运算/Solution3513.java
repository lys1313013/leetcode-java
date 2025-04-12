package 位运算;

/**
 * 3513. 不同 XOR 三元组的数目 I
 * https://leetcode.cn/problems/number-of-unique-xor-triplets-i/description/
 *
 * length大于2时，向上取2的幂
 */
class Solution3513 {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int power = 1;
        while (power <= n) {
            power <<= 1;
        }
        return power;
    }
}