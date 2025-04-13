package 数学;

/**
 * 1922. 统计好数字的数目
 * https://leetcode.cn/problems/count-good-numbers/description/?envType=daily-question&envId=2025-04-13
 *
 * 快速幂运算
 */
class SolutionQuickMul_1922 {
    long mod = 1000000007;

    public int countGoodNumbers(long n) {
        // 奇数 * 4，偶数 * 5
        // 思路为，(n + 1) /2 为偶数的个数 算 5 ^ x次方， n / 2 为 奇数的个数 算 4 ^ x次数 
        return (int) (quickMul(5, ((n + 1) / 2)) * quickMul(4, (n / 2)) % mod);
    }

    public long quickMul(int x, long y) {
        long result = 1;
        long mul = x;
        while (y > 0) {
            if (y % 2 == 1) {
                // 防止奇数被除2后，丢失
                result = result * mul % mod;
            }
            mul = mul * mul % mod;
            y /= 2;
        }
        return result;
    }
}