package 位运算;

/**
 * 342. 4的幂
 */
class Solution0342 {
    public boolean isPowerOfFour(int n) {
        // 是2的幂，且偶数没有1的存在
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }
}
