package 数学;

/**
 * 50. Pow(x, n)
 * https://leetcode.cn/problems/powx-n/description/
 *
 * 快速幂
 */
class SolutionQuickMul_0050 {
    public double myPow(double x, int n) {
        long N = n;
        // 要考虑负数的场景
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    double quickMul(double x, long N) {
        double result = 1.0;
        double mul = x;
        while (N > 0) {
            if (N % 2 == 1) {
                result *= mul;
            }
            mul = mul * mul;
            N /= 2;
        }
        return result;
    }
}