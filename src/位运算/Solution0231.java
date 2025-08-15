package 位运算;

/**
 * 231. 2 的幂
 */
class Solution0231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}