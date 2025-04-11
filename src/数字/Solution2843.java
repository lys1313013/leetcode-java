package 数字;

/**
 * 2843. 统计对称整数的数目
 * https://leetcode.cn/problems/count-symmetric-integers/?envType=daily-question&envId=2025-04-11
 *
 * @author Lys
 * @date 2025/04/11 23:23
 */
public class Solution2843 {
    public int countSymmetricIntegers(int low, int high) {
        int sum = 0;
        for (int i = low; i <= high; i++) {
            // 先判断是不是偶数位
            String str = i + "";
            if (str.length() % 2 == 1) {
                continue;
            }
            String str1 = str.substring(0, str.length() / 2);
            String str2 = str.substring(str.length() / 2);
            int sum1 = 0;
            int sum2 = 0;
            int num1 = Integer.parseInt(str1);
            int num2 = Integer.parseInt(str2);
            while (num1 >0) {
                sum1 += (num1 % 10);
                num1 /= 10;
            }
            while (num2 > 0) {
                sum2 += (num2 % 10);
                num2 /= 10;
            }
            if (sum1 == sum2) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution2843 solution = new Solution2843();
        System.out.println(solution.countSymmetricIntegers(1,100));
    }
}
